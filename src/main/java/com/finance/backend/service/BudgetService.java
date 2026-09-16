package com.finance.backend.service;

import com.finance.backend.dto.request.BudgetRequest;
import com.finance.backend.dto.response.BudgetResponse;

import java.util.List;

public interface BudgetService {
    BudgetResponse addBudget(BudgetRequest budgetRequest);
    BudgetResponse getBudget(Long id);
    List<BudgetResponse> getAllBudgetForUser(Long userId);

}
