package com.mehmet.finance.controllers;

import com.mehmet.finance.dtos.ExpenseDTO;
import com.mehmet.finance.dtos.ExpenseDTOIU;
import com.mehmet.finance.services.impl.ExpenseServiceImpl;
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

    private final ExpenseServiceImpl expenseServiceImpl;

    @PostMapping("/user/{userId}")
    public ResponseEntity<ExpenseDTO> addExpense(@PathVariable Long userId, @Valid @RequestBody ExpenseDTOIU dtoiu) {
        return ResponseEntity.ok(expenseServiceImpl.addExpense(userId, dtoiu));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpenseDTO>> getExpensesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseServiceImpl.getExpensesByUserId(userId));
    }
}
