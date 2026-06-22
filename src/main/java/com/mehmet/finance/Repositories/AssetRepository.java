package com.mehmet.finance.Repositories;

import com.mehmet.finance.Entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> {
    List<Asset> findByUserId(Long userId);
}
