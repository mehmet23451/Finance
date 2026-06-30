package com.mehmet.finance.Services;
import com.mehmet.finance.Dtos.AssetDTO;
import com.mehmet.finance.Dtos.ExpenseDTO;
import com.mehmet.finance.Dtos.IncomeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mehmet.finance.service.ExpenseService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private final AssetService assetService;
    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    public BigDecimal calculate(Long userId){
        BigDecimal totalCost= BigDecimal.ZERO;
        List<AssetDTO> assets= assetService.getAssetsByUserId(userId);
        List<IncomeDTO> incomes=incomeService.getIncomesByUserId(userId);
        List<ExpenseDTO> expenses= expenseService.getExpensesByUserId(userId);

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
