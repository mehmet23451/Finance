package com.mehmet.finance.Services;

import com.mehmet.finance.Dtos.IncomeDTO;
import com.mehmet.finance.Dtos.IncomeDTOIU;
import com.mehmet.finance.Entities.Income;
import com.mehmet.finance.Entities.User;
import com.mehmet.finance.Repositories.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final UserService userService;

    public IncomeDTO addIncome(Long userId, IncomeDTOIU dtoiu){
        User user= userService.getUserById(userId);
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
