package com.finance.backend.service;


import com.finance.backend.dto.request.ExpenseRequest;
import com.finance.backend.dto.response.ExpenseResponse;

public interface ExpenseService {
    ExpenseResponse addExpense(ExpenseRequest request);
    ExpenseResponse getExpense(Long id);

    ExpenseResponse updateExpense(Long id,ExpenseRequest expenseRequest);
    void deleteExpense(Long id);

}
