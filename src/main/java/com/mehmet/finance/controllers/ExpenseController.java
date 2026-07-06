package com.mehmet.finance.controllers;

import com.mehmet.finance.dtos.ExpenseDTO;
import com.mehmet.finance.dtos.ExpenseDTOIU;
import com.mehmet.finance.services.ExpenseService;
import com.mehmet.finance.services.FinanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExpenseController {

    private final ExpenseService expenseServiceImpl;
    private final FinanceService financeService;
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
