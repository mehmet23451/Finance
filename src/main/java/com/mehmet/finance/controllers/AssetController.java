package com.mehmet.finance.controllers;

import com.mehmet.finance.dtos.AssetDTO;
import com.mehmet.finance.dtos.AssetDTOIU;
import com.mehmet.finance.services.FinanceService;
import com.mehmet.finance.services.impl.AssetServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AssetController {

    private final AssetServiceImpl assetServiceImpl;
    private final FinanceService financeService;
    @PostMapping("/user/{userId}")
    public ResponseEntity<AssetDTO> addAsset(@PathVariable Long userId, @Valid @RequestBody AssetDTOIU dtoiu) {
        AssetDTO assetDTO= assetServiceImpl.addAsset(userId,dtoiu);
        financeService.calculate(userId);
        return ResponseEntity.ok(assetDTO);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AssetDTO>> getAssetsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(assetServiceImpl.getAssetsByUserId(userId));
    }
}