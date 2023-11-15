package fi.assignment.countryservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import fi.assignment.countryservice.CountryServiceApplication;
import fi.assignment.countryservice.model.Country;
import fi.assignment.countryservice.service.CountryService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CountryServiceApplication.class)
@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Autowired
    ObjectMapper objectMapper;

    private Collection<Country> countries;

    @BeforeEach
    void setUp() {
        countries = new HashSet<>() {{
            add(new Country("Norway", "NO", "Oslo", "https://flagcdn.com/w320/no.png", 5379475));
            add(new Country("Sweden", "SE", "Stockholm", "https://flagcdn.com/w320/se.png", 10353442));
            add(new Country("Denmark", "DK", "Copenhagen", "https://flagcdn.com/w320/dk.png", 5831404));
        }};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCountries_shouldReturnOkStatus() throws Exception {
        // Arrange
        given(countryService.getCountries()).willReturn(countries);

        // Act
        RequestBuilder getRequest = get("/countries");
        MvcResult result = mockMvc.perform(getRequest).andReturn();

        // Assert
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getCountry_shouldReturnOkStatus() throws Exception {
        // Arrange
        given(countryService.getCountries()).willReturn(countries);

        // Act
        RequestBuilder getRequest = get("/countries?name=Norway");
        ResultActions result = mockMvc.perform(getRequest);

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void add_validCountry_shouldReturnOkStatus() throws Exception {
        // Arrange
        Country countryToAdd = new Country("Finland", "FI", "Helsinki", "https://flagcdn.com/w320/fi.png", 5530719);
        String countryToAddInJson = objectMapper.writeValueAsString(countryToAdd);

        // Act
        RequestBuilder postRequest = post("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(countryToAddInJson);

        ResultActions result = mockMvc.perform(postRequest);

        // Assert
        result.andDo(print());
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void add_invalidCountry_shouldReturnBadRequestStatus() throws Exception {
        // Arrange
        Country countryToAdd = new Country(null, "FI", "Helsinki", "https://flagcdn.com/w320/fi.png", 5530719);
        String countryToAddInJson = objectMapper.writeValueAsString(countryToAdd);

        // Act
        RequestBuilder postRequest = post("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(countryToAddInJson);

        ResultActions result = mockMvc.perform(postRequest);

        // Assert
        result.andDo(print());
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void delete_nonExistingCountry_shouldReturnNotFound() throws Exception {
        // Act
        RequestBuilder deleteRequest = delete("/countries/Finland");

        ResultActions result = mockMvc.perform(deleteRequest);

        // Assert
        result.andDo(print());
        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void delete_nonExistingCountry_shouldReturnNotFoundStatus() throws Exception {
        // Arrange
        Country countryToRemove = new Country("Japan", "JP", "Tokyo", "https://flagcdn.com/w320/jp.png", 125836021);

        // Act
        RequestBuilder deleteRequest = delete("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(countryToRemove));

        ResultActions result = mockMvc.perform(deleteRequest);

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void delete_existingCountry_shouldReturnOkStatus() throws Exception {
        // Arrange
        given(countryService.deleteCountry((Country) ArgumentMatchers.any()))
                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        Country countryToRemove = new Country("Norway", "NO", "Oslo", "https://flagcdn.com/w320/no.png", 5379475);

        // Act
        RequestBuilder deleteRequest = delete("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(countryToRemove));

        ResultActions result = mockMvc.perform(deleteRequest);

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
