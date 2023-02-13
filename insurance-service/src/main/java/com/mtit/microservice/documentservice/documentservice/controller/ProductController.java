package com.mtit.microservice.documentservice.documentservice.controller;

import com.mtit.microservice.documentservice.documentservice.dto.ProductResponse;
import com.mtit.microservice.documentservice.documentservice.dto.ProductRequest;
import com.mtit.microservice.documentservice.documentservice.service.ProductService;
import com.mtit.microservice.documentservice.documentservice.util.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService paymentService;

    @GetMapping("/login")
    public String login(){
        return "Welcome to Claims Service";
    }

    @PostMapping("/Product")
    @ResponseStatus(HttpStatus.CREATED)
    public void newClaim(@RequestBody ProductRequest paymentRequest){
            paymentService.newTransaction(paymentRequest);
    }
    
    @GetMapping("/Product")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllClaims(){
        return paymentService.getAllClaims();
    }

    @GetMapping("/Product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getClaimById(@PathVariable("id") int id){
        return paymentService.getClaimByID(id);
    }

    @PatchMapping("/Product/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProductsByFields(@PathVariable("id") int id, @RequestBody Map<String, Object> fields){
        return paymentService.updateProductsByFields(id, fields);
    }


}
