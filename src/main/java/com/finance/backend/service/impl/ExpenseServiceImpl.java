package com.FinanceMagementSystemBakend.First.service.impl;

import com.FinanceMagementSystemBakend.First.dto.request.ExpenseRequest;
import com.FinanceMagementSystemBakend.First.dto.response.ExpenseResponse;
import com.FinanceMagementSystemBakend.First.entity.Category;
import com.FinanceMagementSystemBakend.First.entity.Expense;
import com.FinanceMagementSystemBakend.First.entity.User;
import com.FinanceMagementSystemBakend.First.exception.ResourceNotFoundException;
import com.FinanceMagementSystemBakend.First.repository.CategoryRepository;
import com.FinanceMagementSystemBakend.First.repository.ExpenseRepository;
import com.FinanceMagementSystemBakend.First.repository.UserRepository;
import com.FinanceMagementSystemBakend.First.service.ExpenseService;
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
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));

        Category category = categoryRepository.findById(expenseRequest.getCategoryid())
                .orElseThrow(()->new ResourceNotFoundException("Category Not Found"));

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
                .orElseThrow(()->new ResourceNotFoundException("Expense Not Found"));

        return ExpenseResponse.builder()
                .id(expense.getId())
                .amount(expense.getAmount())
                .description(expense.getDescription())
                .message("This is Expense Details")
                .build();

    }

    @Override
    public ExpenseResponse updateExpense(Long id,ExpenseRequest expenseRequest){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Expense Not Found"));
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
                .orElseThrow(()->new ResourceNotFoundException("Expense Not Found"));
        expenseRepository.deleteById(id);
    }
}
