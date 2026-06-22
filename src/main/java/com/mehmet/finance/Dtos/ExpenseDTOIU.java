package com.mehmet.finance.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseDTOIU {
    @NotBlank(message = "Gider başlığı boş bırakılamaz")
    private String title;

    @Positive(message = "Gider tutarı pozitif bir sayı olmalıdır")
    private BigDecimal amount;

    @NotBlank(message = "Kategori boş bırakılamaz")
    private String category;

    private LocalDate date;
    private String description;
}
