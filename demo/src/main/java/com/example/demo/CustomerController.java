package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService cs;

    @PutMapping("/add")
    public ResponseEntity<String> addcs(@RequestBody Customer c){
        cs.addCustomer(c);
        return  ResponseEntity.ok("Customer Added Successfully");
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Customer> fetchdetail(@PathVariable String id){
        Customer c = cs.getCustomer(id);
        return ResponseEntity.ok(c);
    }

    @PutMapping("/deposit/{id}/{amount}")
    public ResponseEntity<String> depositamount(@PathVariable String id, @PathVariable double amount){
        cs.deposit(id,amount);
        return ResponseEntity.ok("Deposited SuccessFully");
    }

    @GetMapping("/withdraw/{id}/{amount}")
    public ResponseEntity<String> withdraw(@PathVariable String id, @PathVariable double amount){
        cs.withdraw(id,amount);
        return ResponseEntity.ok("Money WithDraw SuccessFully");
    }

    @GetMapping("/transactionshistory/{id}")
    public ResponseEntity<List<Transaction>> gettransactions(@PathVariable String id){
        List<Transaction> l = cs.getTransactions(id);
        return ResponseEntity.ok(l);
    }
}
