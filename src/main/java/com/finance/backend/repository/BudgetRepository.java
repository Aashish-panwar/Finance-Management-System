package com.finance.backend.repository;

import com.finance.backend.entity.Budget;
import com.finance.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
    List<Budget> findAllByUser_Id(Long userId);
}

