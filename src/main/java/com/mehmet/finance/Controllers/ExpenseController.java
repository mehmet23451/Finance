package com.mehmet.finance.Controllers;

import com.mehmet.finance.Dtos.ExpenseDTO;
import com.mehmet.finance.Dtos.ExpenseDTOIU;
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

    private final com.mehmet.finance.service.ExpenseService expenseService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<ExpenseDTO> addExpense(@PathVariable Long userId, @Valid @RequestBody ExpenseDTOIU dtoiu) {
        return ResponseEntity.ok(expenseService.addExpense(userId, dtoiu));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpenseDTO>> getExpensesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.getExpensesByUserId(userId));
    }
}
