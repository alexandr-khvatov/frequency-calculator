package com.example.frequencycalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    @Schema(minLength = 1, maxLength = 100)
    @Length(min = 1, max = 100)
    @NotNull
    private String value;
}

