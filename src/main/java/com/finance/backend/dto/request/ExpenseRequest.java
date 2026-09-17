package com.FinanceMagementSystemBakend.First.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExpenseRequest {

    @NotNull(message="User ID is required")
    private Long userid;

    @NotNull(message="Category_id is reqired")
    private Long categoryid;

    @NotNull(message = "Expense Amount is required")
    private BigDecimal amount;

    @NotNull(message = "Description is required")
    private String description;

}
