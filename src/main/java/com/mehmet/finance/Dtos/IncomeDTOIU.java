package com.mehmet.finance.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class IncomeDTOIU {
    @NotBlank(message = "Gelir başlığı boş bırakılamaz")
    private String title;

    @Positive(message = "Gelir tutarı pozitif bir sayı olmalıdır")
    private BigDecimal amount;

    private LocalDate date;
    private String description;
}
