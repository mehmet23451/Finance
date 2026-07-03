package com.mehmet.finance.controllers;

import com.mehmet.finance.dtos.ExpenseDTO;
import com.mehmet.finance.dtos.ExpenseDTOIU;
import com.mehmet.finance.services.impl.ExpenseServiceImpl;
import com.mehmet.finance.services.impl.FinanceServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.number.InfinityNumberComparatorHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExpenseController {

    private final ExpenseServiceImpl expenseServiceImpl;
    private final FinanceServiceImpl financeService;
    @PostMapping("/user/{userId}")
    public ResponseEntity<ExpenseDTO> addExpense(@PathVariable Long userId, @Valid @RequestBody ExpenseDTOIU dtoiu) {
        ExpenseDTO expenseDTO= expenseServiceImpl.addExpense(userId,dtoiu);
        financeService.calculate(userId);
        return ResponseEntity.ok(expenseDTO);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpenseDTO>> getExpensesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseServiceImpl.getExpensesByUserId(userId));
    }
}
