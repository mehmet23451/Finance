package com.mehmet.finance.services.impl;

import com.mehmet.finance.dtos.AssetDTO;
import com.mehmet.finance.dtos.AssetDTOIU;
import com.mehmet.finance.entities.Asset;
import com.mehmet.finance.entities.User;
import com.mehmet.finance.repositories.AssetRepository;
import com.mehmet.finance.services.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {
    private final AssetRepository assetRepository;
    private final UserServiceImpl userServiceImpl;
    public AssetDTO addAsset(Long userId, AssetDTOIU dtoiu) {
        User user = userServiceImpl.getUserById(userId);
        Asset asset=new Asset();
        BeanUtils.copyProperties(dtoiu,asset);
        asset.setUser(user);

        Asset savedAsset=assetRepository.save(asset);
        AssetDTO dto= new AssetDTO();
        BeanUtils.copyProperties(savedAsset,dto);
        dto.setUserId(savedAsset.getUser().getId());
        return dto;
    }
    public List<AssetDTO> getAssetsByUserId(Long userId) {
        return assetRepository.findByUserId(userId)
                .stream()
                .map(asset -> {
                    AssetDTO dto = new AssetDTO();
                    BeanUtils.copyProperties(asset, dto);
                    dto.setUserId(asset.getUser().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
