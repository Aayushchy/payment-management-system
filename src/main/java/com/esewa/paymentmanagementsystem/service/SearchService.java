package com.esewa.paymentmanagementsystem.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SearchService {

    //@Async("threadPoolTaskExecutor1")
   @Async
   public CompletableFuture<Integer> searchId(){
    //public void searchId(){
            System.out.println("Thread in SearchId " + Thread.currentThread().getName());
        try{
            Thread.sleep(4000);
            System.out.println("searchId Method Executed");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return CompletableFuture.completedFuture(1);
        //Thread.sleep(2000);
    }
    @Async
    // public CompletableFuture<String> searchId(){
    public CompletableFuture<String> getName(){
        System.out.println("Thread in getName " + Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
            System.out.println("getName Method Executed");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return CompletableFuture.completedFuture("Aayush");
        //Thread.sleep(2000);
    }
}
