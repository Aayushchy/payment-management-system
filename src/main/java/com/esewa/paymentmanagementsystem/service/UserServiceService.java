package com.esewa.paymentmanagementsystem.service;

import com.esewa.paymentmanagementsystem.entity.Transaction;
import com.esewa.paymentmanagementsystem.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceService {

    private final UserServiceService2 method2;
    private final TransactionRepository transactionRepository;




   public Transaction saveTransaction1 (Transaction transaction){
        // Transaction newTransaction = transactionRepository.save(transaction);
        //int a = 2/0;
        Transaction transaction1 = new Transaction();
        transaction1.setRemarks("tests");
        transactionRepository.save(transaction1);

        try{
            return method2.saveTransaction2(transaction);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}