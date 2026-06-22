package com.mehmet.finance.Services;

import com.mehmet.finance.Dtos.AssetDTO;
import com.mehmet.finance.Dtos.AssetDTOIU;
import com.mehmet.finance.Entities.Asset;
import com.mehmet.finance.Entities.User;
import com.mehmet.finance.Repositories.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetRepository assetRepository;
    private final UserService userService;
    public AssetDTO addAsset(Long userId, AssetDTOIU dtoiu) {
        User user = userService.getUserById(userId);
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
