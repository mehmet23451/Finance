package com.mehmet.finance.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class IncomeDTO {
    private Long id;
    private String title;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
    private Long userId;
}
