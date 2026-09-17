package com.finance.backend.repository;

import com.finance.backend.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    List<Expense> findAllByUser_Id(Long userId);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId")
    BigDecimal sumTotalExpenseByUserId(@Param("userId") Long userId);

}
