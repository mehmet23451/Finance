package com.mehmet.finance.services;

import com.mehmet.finance.dtos.AssetDTO;
import com.mehmet.finance.dtos.AssetDTOIU;

import java.util.List;

public interface AssetService {
    AssetDTO addAsset(Long userId, AssetDTOIU dtoiu);
    List<AssetDTO> getAssetsByUserId(Long userId);
}
