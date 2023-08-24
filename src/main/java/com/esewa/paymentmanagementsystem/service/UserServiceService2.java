package com.esewa.paymentmanagementsystem.service;

import com.esewa.paymentmanagementsystem.entity.Transaction;
import com.esewa.paymentmanagementsystem.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceService2 {

    private final TransactionRepository transactionRepository;



    //@Transactional(rollbackFor = Exception.class)
    //@Transactional
    public Transaction saveTransaction2(Transaction transaction){
        Transaction transaction11 = new Transaction();
        transaction11.setAmount(11L);
        Transaction newTransaction = transactionRepository.save(transaction11);
        Transaction transaction2 = transactionRepository.findById(9L).orElse(null);
        int exception = 2/0;
        return newTransaction;
    }

}