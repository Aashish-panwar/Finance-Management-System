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
public class IncomeResponse {
    private Long id;
    private BigDecimal amount;
    private String source;
    private String description;
    private String message;
}
