package com.example.frequencycalculator.service;

import com.example.frequencycalculator.dto.RequestDto;
import com.example.frequencycalculator.dto.ResponceDto;
import jakarta.validation.Valid;

public interface FrequencyCalculatorService {
    ResponceDto calculateFrequency(@Valid RequestDto value);
}
