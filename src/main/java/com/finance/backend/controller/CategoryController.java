package com.finance.backend.controller;

import com.finance.backend.dto.request.CategoryRequest;
import com.finance.backend.dto.response.CategoryResponse;
import com.finance.backend.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.addCategory(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@PathVariable Long userId) {
        return ResponseEntity.ok(categoryService.getAllCategoriesForUser(userId));
    }
}