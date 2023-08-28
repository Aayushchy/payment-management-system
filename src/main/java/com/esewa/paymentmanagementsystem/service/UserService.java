package com.esewa.paymentmanagementsystem.service;

import com.esewa.paymentmanagementsystem.annotation.Authenticate;
import com.esewa.paymentmanagementsystem.entity.Transaction;
import com.esewa.paymentmanagementsystem.entity.User;
import com.esewa.paymentmanagementsystem.repository.TransactionRepository;
import com.esewa.paymentmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final SearchService searchService;

    @Authenticate
    public void getUserList(String userId) {
        System.out.println("In Service");
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    private Integer callBackForId(Integer id) {
        if(id%2==0){
            System.out.println(id.toString().length() + " Digit Odd Id");
            return id*3;
        } else {
            System.out.println(id.toString().length() + " Digit Even Id");
            return id*2;
        }
    }

    //@Async
    public List<User> getAllUser() {

        //CompletableFuture<String> completableFuture = searchService.searchId();
        try{
          //  System.out.println(completableFuture.get());
            System.out.println("Thread in getAllUser " + Thread.currentThread().getName());
           // searchService.searchId();
            //searchService.getName();
            /*CompletableFuture<Integer> userId = searchService.searchId().thenApply((id)-> {
                if(id%2==0){
                    System.out.println(id.toString().length() + " Digit Odd Id");
                    return id*3;
                } else {
                    System.out.println(id.toString().length() + " Digit Even Id");
                    return id*2;
                }
            });*/
            CompletableFuture<Integer> userId = searchService.searchId().thenApply(this::callBackForId);

            CompletableFuture<String> name = searchService.getName();
            //System.out.println("Before join");
            CompletableFuture.allOf(userId,name).join();

            System.out.println("Result " + userId.get()+ " " + name.get());
           // System.out.println("End of program");

        }
        catch (Exception e){
            log.info(e.getMessage());
        }

        //log.info("Searching Completed");
        return userRepository.findAll();

    }

    @Transactional
    public User getAllUser(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
