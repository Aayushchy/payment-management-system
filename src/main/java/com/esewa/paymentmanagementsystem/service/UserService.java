package com.esewa.paymentmanagementsystem.service;

import com.esewa.paymentmanagementsystem.annotation.Authenticate;
import com.esewa.paymentmanagementsystem.entity.Transaction;
import com.esewa.paymentmanagementsystem.entity.User;
import com.esewa.paymentmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserServiceService userServiceService;

    @Authenticate
    public void getUserList(String userId) {
        System.out.println("In Service");
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction){
        //Transaction newTransaction = transactionRepository.save(transaction);
        //int a = 2/0;
        return userServiceService.saveTransaction1(transaction);
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Transactional
    public User getAllUser(Long id){
        User usr = userRepository.findUserById(id);
        return userRepository.findById(id).get();
    }
}
