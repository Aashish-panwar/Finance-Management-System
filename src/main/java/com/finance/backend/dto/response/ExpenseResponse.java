package com.FinanceMagementSystemBakend.First.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ExpenseResponse {
    private long id;
    private Long categoryid;
    private BigDecimal amount;
    private String description;
    private String message;
}
