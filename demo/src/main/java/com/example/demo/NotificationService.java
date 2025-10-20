package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async
    public void notifydeposit(Customer customer, double amount){
        System.out.println("Notification Rs: " + amount + "deposited to " + customer.getName());
    }
    @Async
    public void notifywithdrawl(Customer customer, double amount){
        System.out.println("Notification Rs: " + amount + "withdraw from " + customer.getName() + "account");
    }
}
