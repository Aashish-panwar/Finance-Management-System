package com.finance.backend.service;

import com.finance.backend.dto.request.CategoryRequest;
import com.finance.backend.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse addCategory(CategoryRequest request);
    List<CategoryResponse> getAllCategoriesForUser(Long userId);
}