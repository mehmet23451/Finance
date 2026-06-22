package com.mehmet.finance.Repositories;

import com.mehmet.finance.Entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {
    List<Income> findByUserId(Long userId);
}
