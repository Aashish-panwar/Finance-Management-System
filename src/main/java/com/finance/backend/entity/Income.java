package com.finance.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "income")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Income extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String source;

    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
