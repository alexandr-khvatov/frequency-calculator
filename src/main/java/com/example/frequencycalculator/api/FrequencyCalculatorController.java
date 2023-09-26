package com.example.frequencycalculator.api;

import com.example.frequencycalculator.dto.RequestDto;
import com.example.frequencycalculator.dto.ResponceDto;
import com.example.frequencycalculator.service.FrequencyCalculatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FrequencyCalculatorController {
    private final FrequencyCalculatorService frequencyCalculatorService;

    @GetMapping("/calculate")
    public ResponceDto calculateVacationPay(RequestDto requestDto) {
        return frequencyCalculatorService.calculateFrequency(requestDto);
    }
}
