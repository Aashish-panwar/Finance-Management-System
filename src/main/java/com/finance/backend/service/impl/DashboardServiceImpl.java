package com.finance.backend.service.impl;


import com.finance.backend.dto.response.DashboardResponse;
import com.finance.backend.entity.User;
import com.finance.backend.exception.ResourceNotFoundException;
import com.finance.backend.repository.ExpenseRepository;
import com.finance.backend.repository.IncomeRepository;
import com.finance.backend.repository.UserRepository;
import com.finance.backend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public DashboardResponse getDashboard(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User Not found"));

        BigDecimal totalIncome = incomeRepository.sumTotalIncomeByUserId(id);
        if (totalIncome == null) totalIncome = BigDecimal.ZERO;

        BigDecimal totalExpense = expenseRepository.sumTotalExpenseByUserId(id);
        if (totalExpense == null) totalExpense = BigDecimal.ZERO;

        BigDecimal balance = totalIncome.subtract(totalExpense);

        return DashboardResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .balance(balance)
                .build();
    }

}
