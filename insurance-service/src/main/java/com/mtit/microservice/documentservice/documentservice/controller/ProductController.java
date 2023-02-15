package com.mtit.microservice.documentservice.documentservice.controller;

import com.mtit.microservice.documentservice.documentservice.dto.FromRequest;
import com.mtit.microservice.documentservice.documentservice.dto.ProductResponse;
import com.mtit.microservice.documentservice.documentservice.dto.ProductRequest;
import com.mtit.microservice.documentservice.documentservice.service.FormService;
import com.mtit.microservice.documentservice.documentservice.service.ProductService;
import com.mtit.microservice.documentservice.documentservice.util.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService paymentService;

    @Autowired
    private FormService formService;

    @GetMapping("/login")
    public String login(){
        return "Welcome to My WEB API";
    }

    @PostMapping("/contact")
    @ResponseStatus(HttpStatus.CREATED)
    public void formSubmition(@RequestBody FromRequest fromRequest) throws IOException {
        formService.formSubmission(fromRequest);
    }

    @PostMapping("/Product")
    @ResponseStatus(HttpStatus.CREATED)
    public void newClaim(@RequestBody ProductRequest paymentRequest, @RequestParam("file")MultipartFile file) throws IOException {
            paymentService.newTransaction(paymentRequest, file);
    }
    
    @GetMapping("/Product")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllClaims(){
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
