package com.finance.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Category name is required")
    private String name;

    @NotBlank(message = "Category type is required (e.g., INCOME or EXPENSE)")
    private String type;
}