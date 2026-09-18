package com.FinanceMagementSystemBakend.First.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IncomeRequest {

    @NotNull(message = "User Id is required")
    private Long userId;

    @NotNull(message = "Income Amount is required")
    private BigDecimal amount;

    @NotNull(message = "Source is required")
    private String source;

    private String description;
}
