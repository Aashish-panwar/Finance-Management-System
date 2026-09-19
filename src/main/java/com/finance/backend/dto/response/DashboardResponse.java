package com.finance.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class DashboardResponse {
    private Long userId;
    private String name;
    private String email;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal balance;
}