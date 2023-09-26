package com.example.frequencycalculator.integration.api;

import com.example.frequencycalculator.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RequiredArgsConstructor
class FrequencyCalculatorControllerIT extends IntegrationTestBase {

    private final MockMvc mockMvc;

    public static String URL = "/api/v1";

    @Test
    void calculateFrequency_shouldReturn200_whenSucceed() throws Exception {
        this.mockMvc.perform(get(URL + "/calculate")
                        .param("value", "aaaaabcccc")
                )
                .andExpectAll(
                        status().isOk(),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.frequency.a").value(5),
                        jsonPath("$.frequency.b").value(1),
                        jsonPath("$.frequency.c").value(4)
                );
    }

    @Test
    void calculateFrequency_shouldReturn400_whenValueIsNull() throws Exception {
        this.mockMvc.perform(get(URL + "/calculate")
                )
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.message").value("Validation error")
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"",
            "555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555"})
    void calculateFrequency_shouldReturn400_whenRestrictionsViolated(String inputValue) throws Exception {
        this.mockMvc.perform(get(URL + "/calculate")
                        .param("value", inputValue)
                )
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.message").value("Validation error")
                );
    }

}