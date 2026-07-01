package com.mehmet.finance.services;

import com.mehmet.finance.dtos.ExpenseDTO;
import com.mehmet.finance.dtos.ExpenseDTOIU;

import java.util.List;

public interface ExpenseService {
    ExpenseDTO addExpense(Long userId, ExpenseDTOIU dtoiu);
    List<ExpenseDTO> getExpensesByUserId(Long userId);
}
