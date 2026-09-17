package com.FinanceMagementSystemBakend.First.service;


import com.FinanceMagementSystemBakend.First.dto.request.ExpenseRequest;
import com.FinanceMagementSystemBakend.First.dto.response.ExpenseResponse;

public interface ExpenseService {
    ExpenseResponse addExpense(ExpenseRequest request);
    ExpenseResponse getExpense(Long id);

    ExpenseResponse updateExpense(Long id,ExpenseRequest expenseRequest);
    void deleteExpense(Long id);

}
