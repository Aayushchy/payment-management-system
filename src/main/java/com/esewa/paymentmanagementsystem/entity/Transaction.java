package com.esewa.paymentmanagementsystem.entity;

import com.esewa.paymentmanagementsystem.constant.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;
    private String remarks;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @JsonProperty("user_id")
    private Long userId;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;
}
