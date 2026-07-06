package com.mehmet.finance.controllers;

import com.mehmet.finance.dtos.IncomeDTO;
import com.mehmet.finance.dtos.IncomeDTOIU;
import com.mehmet.finance.services.FinanceService;
import com.mehmet.finance.services.IncomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class IncomeController {
    private final IncomeService incomeService;
    private final FinanceService financeService;
    @PostMapping("/user/{userId}")
    public ResponseEntity<IncomeDTO> addIncome(@PathVariable Long userId,@Valid @RequestBody IncomeDTOIU dtoiu){
        IncomeDTO incomeDTO= incomeService.addIncome(userId,dtoiu);
        financeService.calculate(userId);
        return ResponseEntity.ok(incomeDTO);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IncomeDTO>> getIncomesByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(incomeService.getIncomesByUserId(userId));
    }
}
