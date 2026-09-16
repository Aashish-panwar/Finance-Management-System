package com.finance.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BudgetResponse {
    private Long id;
    private Long categoryid;
    private BigDecimal amount;
    private int month;
    private int year;
    private String message;
}
