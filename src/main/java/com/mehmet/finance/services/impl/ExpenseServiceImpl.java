package com.mehmet.finance.services.impl;

import com.mehmet.finance.dtos.ExpenseDTO;
import com.mehmet.finance.dtos.ExpenseDTOIU;
import com.mehmet.finance.entities.Expense;
import com.mehmet.finance.repositories.ExpenseRepository;
import com.mehmet.finance.entities.User;
import com.mehmet.finance.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserServiceImpl userServiceImpl;
    public ExpenseDTO addExpense(Long userId, ExpenseDTOIU dtoiu) {
        User user = userServiceImpl.getUserById(userId);
        Expense expense=new Expense();
        BeanUtils.copyProperties(dtoiu,expense);
        expense.setUser(user);
        Expense savedExpense= expenseRepository.save(expense);
        ExpenseDTO dto= new ExpenseDTO();
        BeanUtils.copyProperties(savedExpense,dto);
        dto.setUserId(savedExpense.getUser().getId());
        return dto;
    }

    public List<ExpenseDTO> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId)
                .stream()
                .map(expense -> {
                    ExpenseDTO dto = new ExpenseDTO();
                    BeanUtils.copyProperties(expense, dto);
                    dto.setUserId(expense.getUser().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}