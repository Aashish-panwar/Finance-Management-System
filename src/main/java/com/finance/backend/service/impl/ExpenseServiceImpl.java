package com.finance.backend.service.impl;

import com.finance.backend.dto.request.ExpenseRequest;
import com.finance.backend.dto.response.ExpenseResponse;
import com.finance.backend.entity.Category;
import com.finance.backend.entity.Expense;
import com.finance.backend.entity.User;
import com.finance.backend.repository.CategoryRepository;
import com.finance.backend.repository.ExpenseRepository;
import com.finance.backend.repository.UserRepository;
import com.finance.backend.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ExpenseResponse addExpense(ExpenseRequest expenseRequest){
        User user = userRepository.findById(expenseRequest.getUserid())
                .orElseThrow(()->new RuntimeException("User Not Found"));

        Category category = categoryRepository.findById(expenseRequest.getCategoryid())
                .orElseThrow(()->new RuntimeException("Category Not Found"));

        Expense expense = Expense.builder()
                .amount(expenseRequest.getAmount())
                .description(expenseRequest.getDescription())
                .user(user)
                .category(category)
                .build();

        Expense saved = expenseRepository.save(expense);

        return ExpenseResponse.builder()
                .id(saved.getId())
                .categoryid(saved.getCategory().getId())
                .amount(saved.getAmount())
                .description(saved.getDescription())
                .message("Expense Added Successfully")
                .build();
    }

    @Override
    public ExpenseResponse getExpense(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Expense Not Found"));

        return ExpenseResponse.builder()
                .id(expense.getId())
                .categoryid(expense.getCategory().getId())
                .amount(expense.getAmount())
                .description(expense.getDescription())
                .message("This is Expense Details")
                .build();

    }

    @Override
    public ExpenseResponse updateExpense(Long id,ExpenseRequest expenseRequest){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Expense Not Found"));
        expense.setAmount(expenseRequest.getAmount());
        expense.setDescription(expenseRequest.getDescription());

        Expense saved = expenseRepository.save(expense);

        return ExpenseResponse.builder()
                .id(saved.getId())
                .amount(saved.getAmount())
                .description(saved.getDescription())
                .message("Expense Updated Successfully")
                .build();
    }

    @Override
    public void deleteExpense(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Expense Not Found"));
        expenseRepository.deleteById(id);
    }
}
