package com.FinanceMagementSystemBakend.First.controller;

import com.FinanceMagementSystemBakend.First.dto.request.IncomeRequest;
import com.FinanceMagementSystemBakend.First.dto.response.IncomeResponse;
import com.FinanceMagementSystemBakend.First.service.IncomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/incomes")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeResponse> addIncome(@Valid @RequestBody IncomeRequest  request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(incomeService.addIncome(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeResponse> getIncome(@PathVariable Long id){

        return ResponseEntity.ok(incomeService.getIncome(id));
    }

}
