package com.mehmet.finance.Repositories;

import com.mehmet.finance.Entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByUserId(Long userId);
}
