package com.mehmet.finance.Controllers;

import com.mehmet.finance.Dtos.AssetDTO;
import com.mehmet.finance.Dtos.AssetDTOIU;
import com.mehmet.finance.Services.AssetService;
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

    private final AssetService assetService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<AssetDTO> addAsset(@PathVariable Long userId, @Valid @RequestBody AssetDTOIU dtoiu) {
        return ResponseEntity.ok(assetService.addAsset(userId, dtoiu));
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AssetDTO>> getAssetsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(assetService.getAssetsByUserId(userId));
    }
}