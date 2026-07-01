package com.mehmet.finance.controllers;

import com.mehmet.finance.services.impl.FinanceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/finance")
@RequiredArgsConstructor
public class FinanceController {
    private final FinanceServiceImpl financeServiceImpl;

    @GetMapping("/calculate/{userId}")
    public ResponseEntity<BigDecimal> calculate(@PathVariable Long userId){
        BigDecimal result= financeServiceImpl.calculate(userId);
        return ResponseEntity.ok(result);
    }

}
