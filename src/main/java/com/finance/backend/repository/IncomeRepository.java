package com.finance.backend.repository;

import com.finance.backend.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface IncomeRepository extends JpaRepository<Income,Long> {
    //Optional<Income> findById(long id);

    List<Income> findAllByUser_Id(Long userId);

    @Query("SELECT SUM(i.amount) FROM Income i WHERE i.user.id = :userId")
    BigDecimal sumTotalIncomeByUserId(@Param("userId") Long userId);
}
