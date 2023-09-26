package com.example.frequencycalculator.service;

import com.example.frequencycalculator.dto.RequestDto;
import com.example.frequencycalculator.dto.ResponceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FrequencyCalculatorServiceImplTest {

    private FrequencyCalculatorServiceImpl frequencyCalculatorService;

    @BeforeEach
    void beforeEach() {
        frequencyCalculatorService = new FrequencyCalculatorServiceImpl();
    }

   @Test
    void calculateFrequency1() {
        var actual = frequencyCalculatorService.calculateFrequency(new RequestDto(""));
        assertThat(actual).isNotNull();
//        assertThat(actual.frequency()).isEqualTo(expected.frequency());
    }


    @ParameterizedTest
    @MethodSource("getArgumentsForCalculateFrequency")
    void calculateFrequency(RequestDto inputRequest, ResponceDto expected) {
        var actual = frequencyCalculatorService.calculateFrequency(inputRequest);
        assertThat(actual).isNotNull();
        assertThat(actual.frequency()).isEqualTo(expected.frequency());
    }


    static Stream<Arguments> getArgumentsForCalculateFrequency() {
        return Stream.of(
                Arguments.of("aaabbbcc", new ResponceDto(Map.of('a', 3L, 'b', 3L, 'c', 2L))),
                Arguments.of("aaaaa", new ResponceDto(Map.of('a', 5L))),
                Arguments.of("a", new ResponceDto(Map.of('a', 1L)))
        );
    }
}