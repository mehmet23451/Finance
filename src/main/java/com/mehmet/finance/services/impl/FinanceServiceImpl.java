package com.mehmet.finance.services.impl;
import com.mehmet.finance.dtos.AssetDTO;
import com.mehmet.finance.dtos.ExpenseDTO;
import com.mehmet.finance.dtos.IncomeDTO;
import com.mehmet.finance.services.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService {
    private final AssetServiceImpl assetServiceImpl;
    private final IncomeServiceImpl incomeService;
    private final ExpenseServiceImpl expenseServiceImpl;
    public BigDecimal calculate(Long userId){
        BigDecimal totalCost= BigDecimal.ZERO;
        List<AssetDTO> assets= assetServiceImpl.getAssetsByUserId(userId);
        List<IncomeDTO> incomes=incomeService.getIncomesByUserId(userId);
        List<ExpenseDTO> expenses= expenseServiceImpl.getExpensesByUserId(userId);

        for (AssetDTO asset: assets) {
            totalCost = totalCost.add(asset.getAverageCost().multiply( asset.getQuantity()));
        }
        for (IncomeDTO income : incomes){
            totalCost=totalCost.add(income.getAmount());
        }
        for (ExpenseDTO expense : expenses){
            totalCost=totalCost.subtract(expense.getAmount());
        }
        return totalCost;

    }
}
