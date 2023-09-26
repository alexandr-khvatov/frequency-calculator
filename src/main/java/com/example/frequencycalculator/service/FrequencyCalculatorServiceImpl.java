package com.example.frequencycalculator.service;

import com.example.frequencycalculator.dto.RequestDto;
import com.example.frequencycalculator.dto.ResponceDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Validated
public class FrequencyCalculatorServiceImpl implements FrequencyCalculatorService {
    @Override
    public ResponceDto calculateFrequency(@Valid RequestDto input) {
        Map<Character, Long> frequencies = new HashMap<>();
        for (char ch : input.getValue().toCharArray())
            frequencies.put(ch, frequencies.getOrDefault(ch, 0L) + 1);
        var sortedFrequencies = frequencies.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return new ResponceDto(sortedFrequencies);
    }
}
