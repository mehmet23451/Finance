package com.mehmet.finance.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AssetDTOIU {
    @NotBlank(message = "Varlık adı boş bırakılamaz")
    private String name;

    @NotBlank(message = "Varlık tipi boş bırakılamaz")
    private String type;

    @NotBlank(message = "Sembol boş bırakılamaz")
    private String symbol;

    @Positive(message = "Miktar pozitif olmalıdır")
    private BigDecimal quantity;

    @Positive(message = "Ortalama maliyet pozitif olmalıdır")
    private BigDecimal averageCost;
}
