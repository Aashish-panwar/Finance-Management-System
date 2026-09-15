package com.finance.backend.service.impl;

import com.finance.backend.dto.request.CategoryRequest;
import com.finance.backend.dto.response.CategoryResponse;
import com.finance.backend.entity.Category;
import com.finance.backend.entity.User;
import com.finance.backend.repository.CategoryRepository;
import com.finance.backend.repository.UserRepository;
import com.finance.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public CategoryResponse addCategory(CategoryRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Category category = new Category();
        category.setName(request.getName());
        category.setType(request.getType());
        category.setUser(user); // Make sure your Category entity field is named 'user'

        Category saved = categoryRepository.save(category);

        return CategoryResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .type(saved.getType())
                .message("Category Added Successfully")
                .build();
    }

    @Override
    public List<CategoryResponse> getAllCategoriesForUser(Long userId) {
        List<Category> categories = categoryRepository.findAllByUser_Id(userId);

        return categories.stream().map(cat -> CategoryResponse.builder()
                .id(cat.getId())
                .name(cat.getName())
                .type(cat.getType())
                .message("Category Retrieved")
                .build()
        ).collect(Collectors.toList());
    }
}