package com.esewa.paymentmanagementsystem.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAuthentication {

    //@Before("execution(* com.esewa.paymentmanagementsystem.service.UserService.getUserList(..))")
    @Before("@annotation(com.esewa.paymentmanagementsystem.annotation.Authenticate) && args(userId)")
    public void authenticate(String userId) {
        System.out.println("Aspect Code Running: Authenticated "+ userId);
    }

}
