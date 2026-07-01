package com.mehmet.finance.services;

import com.mehmet.finance.dtos.IncomeDTO;
import com.mehmet.finance.dtos.IncomeDTOIU;

import java.util.List;

public interface IncomeService {
    IncomeDTO addIncome(Long userId, IncomeDTOIU dtoiu);
    List<IncomeDTO> getIncomesByUserId(Long userId);
}
