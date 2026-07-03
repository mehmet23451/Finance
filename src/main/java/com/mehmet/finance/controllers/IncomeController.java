package com.mehmet.finance.controllers;

import com.mehmet.finance.dtos.IncomeDTO;
import com.mehmet.finance.dtos.IncomeDTOIU;
import com.mehmet.finance.services.impl.FinanceServiceImpl;
import com.mehmet.finance.services.impl.IncomeServiceImpl;
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
    private final IncomeServiceImpl incomeServiceImpl;
    private final FinanceServiceImpl financeService;
    @PostMapping("/user/{userId}")
    public ResponseEntity<IncomeDTO> addIncome(@PathVariable Long userId,@Valid @RequestBody IncomeDTOIU dtoiu){
        IncomeDTO incomeDTO= incomeServiceImpl.addIncome(userId,dtoiu);
        financeService.calculate(userId);
        return ResponseEntity.ok(incomeDTO);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IncomeDTO>> getIncomesByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(incomeServiceImpl.getIncomesByUserId(userId));
    }
}
