package com.finance.backend.controller;

import com.finance.backend.dto.request.ExpenseRequest;
import com.finance.backend.dto.response.ExpenseResponse;
import com.finance.backend.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponse> addExpense(@Valid @RequestBody ExpenseRequest expenseRequest){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(expenseService.addExpense(expenseRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getExpense(@PathVariable Long id){

        return ResponseEntity.ok(expenseService.getExpense(id));
    }

    


    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponse> updateExpense(@PathVariable Long id,@Valid @RequestBody ExpenseRequest expenseRequest){
        return ResponseEntity.ok(expenseService.updateExpense(id,expenseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense has been Deleted");
    }
}
