package com.FinanceMagementSystemBakend.First.service;

import com.FinanceMagementSystemBakend.First.dto.request.IncomeRequest;
import com.FinanceMagementSystemBakend.First.dto.response.IncomeResponse;

public interface IncomeService {
    IncomeResponse addIncome(IncomeRequest request);
    IncomeResponse getIncome(Long id);
}
