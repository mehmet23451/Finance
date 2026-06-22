package com.mehmet.finance.service;

import com.mehmet.finance.Dtos.ExpenseDTO;
import com.mehmet.finance.Dtos.ExpenseDTOIU;
import com.mehmet.finance.Entities.Expense;
import com.mehmet.finance.Repositories.ExpenseRepository;
import com.mehmet.finance.Services.UserService;
import com.mehmet.finance.Entities.Income;
import com.mehmet.finance.Entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    public ExpenseDTO addExpense(Long userId, ExpenseDTOIU dtoiu) {
        User user = userService.getUserById(userId);
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