package com.mehmet.finance.Dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseDTO {
    private Long id;
    private String title;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private String description;
    private Long userId;
}
