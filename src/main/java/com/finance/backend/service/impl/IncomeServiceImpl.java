package com.FinanceMagementSystemBakend.First.service.impl;

import com.FinanceMagementSystemBakend.First.dto.request.IncomeRequest;
import com.FinanceMagementSystemBakend.First.dto.response.IncomeResponse;
import com.FinanceMagementSystemBakend.First.entity.Income;
import com.FinanceMagementSystemBakend.First.entity.User;
import com.FinanceMagementSystemBakend.First.exception.ResourceNotFoundException;
import com.FinanceMagementSystemBakend.First.repository.IncomeRepository;
import com.FinanceMagementSystemBakend.First.repository.UserRepository;
import com.FinanceMagementSystemBakend.First.service.IncomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;

    @Override
    public IncomeResponse addIncome(IncomeRequest request){

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()->new ResourceNotFoundException("User Not Found"));

        Income income = Income.builder()
                .amount(request.getAmount())
                .source(request.getSource())
                .description(request.getDescription())
                .user(user)
                .build();

        Income saved = incomeRepository.save(income);

        return IncomeResponse.builder()
                .id(saved.getId())
                .amount(saved.getAmount())
                .source(saved.getSource())
                .description(saved.getDescription())
                .message("Income Details is added")
                .build();
    }

    @Override
    public IncomeResponse getIncome(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income Not Found"));

        return IncomeResponse.builder()
                .id(income.getId())
                .amount(income.getAmount())
                .source(income.getSource())
                .description(income.getDescription())
                .message("This is Income Details ")
                .build();

    }

}
