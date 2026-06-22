package com.mehmet.finance.Controllers;

import com.mehmet.finance.Dtos.IncomeDTO;
import com.mehmet.finance.Dtos.IncomeDTOIU;
import com.mehmet.finance.Services.IncomeService;
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

    @PostMapping("/user/{userId}")
    public ResponseEntity<IncomeDTO> addIncome(@PathVariable Long userId,@Valid @RequestBody IncomeDTOIU dtoiu){
        return ResponseEntity.ok(incomeService.addIncome(userId,dtoiu));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IncomeDTO>> getIncomesByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(incomeService.getIncomesByUserId(userId));
    }
}
