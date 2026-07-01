package com.mehmet.finance.services.impl;

import com.mehmet.finance.dtos.IncomeDTO;
import com.mehmet.finance.dtos.IncomeDTOIU;
import com.mehmet.finance.entities.Income;
import com.mehmet.finance.entities.User;
import com.mehmet.finance.repositories.IncomeRepository;
import com.mehmet.finance.services.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final UserServiceImpl userServiceImpl;

    public IncomeDTO addIncome(Long userId, IncomeDTOIU dtoiu){
        User user= userServiceImpl.getUserById(userId);
        Income income= new Income();
        BeanUtils.copyProperties(dtoiu,income);
        income.setUser(user);
        Income savedIncome= incomeRepository.save(income);
        IncomeDTO dto= new IncomeDTO();
        BeanUtils.copyProperties(savedIncome,dto);
        dto.setUserId(savedIncome.getUser().getId());
        return dto;

    }
    public List<IncomeDTO> getIncomesByUserId(Long userId) {
        return incomeRepository.findByUserId(userId)
                .stream()
                .map(income -> {
                    // convertToDTO metodu yerine Lambda içinde anlık dönüşüm!
                    IncomeDTO dto = new IncomeDTO();
                    BeanUtils.copyProperties(income, dto);
                    dto.setUserId(income.getUser().getId());
                    return dto;
                })
                .collect(Collectors.toList());

    }
}
