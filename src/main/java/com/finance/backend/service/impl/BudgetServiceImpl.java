package com.finance.backend.service.impl;

import com.finance.backend.dto.request.BudgetRequest;
import com.finance.backend.dto.response.BudgetResponse;
import com.finance.backend.entity.Budget;
import com.finance.backend.entity.Category;
import com.finance.backend.entity.User;
import com.finance.backend.exception.ResourceNotFoundException;
import com.finance.backend.repository.BudgetRepository;
import com.finance.backend.repository.CategoryRepository;
import com.finance.backend.repository.UserRepository;
import com.finance.backend.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public BudgetResponse addBudget(BudgetRequest budgetRequest){

        User user = userRepository.findById(budgetRequest.getUserid())
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        Category category = categoryRepository.findById(budgetRequest.getCategoryid())
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        Budget budget = Budget.builder()
                .amount(budgetRequest.getAmount())
                .month(budgetRequest.getMonth())
                .year(budgetRequest.getYear())
                .user(user)
                .category(category)
                .build();

        Budget saved = budgetRepository.save(budget);

        return BudgetResponse.builder()
                .id(saved.getId())
                .categoryid(saved.getCategory().getId())
                .amount(saved.getAmount())
                .month(saved.getMonth())
                .year(saved.getYear())
                .message("Budget Added Successfully")
                .build();
    }

    public BudgetResponse getBudget(Long id){
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Budget Not Found"));
        return BudgetResponse.builder()
                .id(budget.getId())
                .categoryid(budget.getCategory().getId())
                .amount(budget.getAmount())
                .month(budget.getMonth())
                .year(budget.getYear())
                .message("Budget Get Successfully")
                .build();
    }

    @Override
    public List<BudgetResponse> getAllBudgetForUser(Long userId) {
        List<Budget> categories = budgetRepository.findAllByUser_Id(userId);

        return categories.stream().map(budget -> BudgetResponse.builder()
                .id(budget.getId())
                .categoryid(budget.getCategory().getId())
                .amount(budget.getAmount())
                .month(budget.getMonth())
                .year(budget.getYear())
                .message("Budget Get Successfully")
                .build()
        ).collect(Collectors.toList());
    }
}