package com.mehmet.finance.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AssetDTO {
    private Long id;
    private String name;
    private String type;
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal averageCost;
    private Long userId;
}
