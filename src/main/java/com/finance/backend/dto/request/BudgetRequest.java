package com.finance.backend.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BudgetRequest {
    @NotNull(message="User ID is required")
    private Long userid;

    @NotNull(message="Category_id is reqired")
    private Long categoryid;


    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length=2)
    private int month;

    @Column(nullable = false, length=4)
    private int year;
}

