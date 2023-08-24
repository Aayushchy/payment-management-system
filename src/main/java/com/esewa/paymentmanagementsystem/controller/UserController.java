package com.esewa.paymentmanagementsystem.controller;

import com.esewa.paymentmanagementsystem.entity.Transaction;
import com.esewa.paymentmanagementsystem.entity.User;
import com.esewa.paymentmanagementsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @GetMapping("user-list")
    public String getUserList(){
        System.out.println("Executing Controller");
        userService.getUserList("12321");
        return "OK";
    }
    @PostMapping("save-user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PostMapping("save-transaction")
    public Transaction saveUser(@RequestBody Transaction transaction) throws Exception {
        return userService.saveTransaction(transaction);
    }


    @RequestMapping(value = "get-all-user", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        logger.info("Retrieving User List");
        return  userService.getAllUser();
    }
    @GetMapping("get-user/{id}")

    public User getAllUsers(@PathVariable("id") Long id){
        return  userService.getAllUser(id);
    }
}
