package com.mehmet.finance.controllers;

import com.mehmet.finance.dtos.IncomeDTO;
import com.mehmet.finance.dtos.IncomeDTOIU;
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

    @PostMapping("/user/{userId}")
    public ResponseEntity<IncomeDTO> addIncome(@PathVariable Long userId,@Valid @RequestBody IncomeDTOIU dtoiu){
        return ResponseEntity.ok(incomeServiceImpl.addIncome(userId,dtoiu));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IncomeDTO>> getIncomesByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(incomeServiceImpl.getIncomesByUserId(userId));
    }
}
