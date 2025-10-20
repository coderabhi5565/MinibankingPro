package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    private Map<String, Customer> customerMap = new HashMap<>();
    private Map<String, List<Transaction>> transactionMap = new HashMap<>();
    private long transactionCounter = 1;

    @Autowired
    NotificationService notificationService;

    public void addCustomer(Customer customer){
        if(customerMap.containsKey(customer.getId())){
            throw new RuntimeException("Customer with same ID already exists");
        }
        customerMap.put(customer.getId(), customer);
        transactionMap.put(customer.getId(), new ArrayList<>());
    }


    public Customer getCustomer(String customerId){
        Customer customer = customerMap.get(customerId);
        if(customer == null){
            throw new RuntimeException("Customer Not Found");
        }
        return customer;
    }


    public void deposit(String customerId, double amount){
        Customer customer = getCustomer(customerId);
        customer.deposit(amount);

        Transaction txn = new Transaction(transactionCounter++, "DEPOSIT", amount);
        transactionMap.get(customerId).add(txn);
        notificationService.notifydeposit(customer,amount);
    }


    public void withdraw(String customerId, double amount){
        Customer customer = getCustomer(customerId);
        customer.withdraw(amount);

        Transaction txn = new Transaction(transactionCounter++, "WITHDRAW", amount);
        transactionMap.get(customerId).add(txn);
        notificationService.notifywithdrawl(customer,amount);
    }

    public List<Transaction> getTransactions(String customerId){
        if(!transactionMap.containsKey(customerId)){
            throw new RuntimeException("Customer Not Found");
        }
        return transactionMap.get(customerId);
    }
}
