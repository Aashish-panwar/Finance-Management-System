package com.finance.backend.controller;

import com.finance.backend.dto.request.BudgetRequest;
import com.finance.backend.dto.response.BudgetResponse;
import com.finance.backend.service.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/budgets")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    public ResponseEntity<BudgetResponse> addBudget(@Valid @RequestBody BudgetRequest budgetRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(budgetService.addBudget(budgetRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetResponse> getBudget(@PathVariable Long id){
        return ResponseEntity.ok(budgetService.getBudget(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BudgetResponse>> getAllCategories(@PathVariable Long userId) {
        return ResponseEntity.ok(budgetService.getAllBudgetForUser(userId));
    }


}
