package com.finance.backend.service;


import com.finance.backend.dto.request.IncomeRequest;
import com.finance.backend.dto.response.IncomeResponse;

public interface IncomeService {
    IncomeResponse addIncome(IncomeRequest request);
    IncomeResponse getIncome(Long id);
}
