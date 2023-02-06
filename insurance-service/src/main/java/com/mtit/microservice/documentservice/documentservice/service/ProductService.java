package com.mtit.microservice.documentservice.documentservice.service;

import com.mtit.microservice.documentservice.documentservice.dto.ProductResponse;
import com.mtit.microservice.documentservice.documentservice.dto.ProductRequest;
import com.mtit.microservice.documentservice.documentservice.util.Product;
import com.mtit.microservice.documentservice.documentservice.repository.ProductRepositroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepositroy productRepositroy;
    @Autowired
    private WebClient.Builder webClient;

    public void newTransaction (ProductRequest paymentRequest){
        Product claim = Product.builder()
                //.id(paymentRequest.getId())
                .name(paymentRequest.getName())
                .email(paymentRequest.getEmail())
                .amount(paymentRequest.getAmount())
                .date(paymentRequest.getDate())
                .claimId(paymentRequest.getClaimId())
                .status(paymentRequest.getStatus())
                .build();


            productRepositroy.save(claim);
            log.info("Product " + claim.getId() + " is saved");

    }

    public List<Product> getAllClaims(){
        List<Product> paymentList = productRepositroy.findAll();

        return paymentList;

        //return paymentList.stream().map(this::mapToClaimResponse).toList();
    }

    private ProductResponse mapToClaimResponse(Product payment) {
        log.info("Product " + payment.getId() + " was retrieved");

        return ProductResponse.builder()
                .id(payment.getId())
                .name(payment.getName())
                .email(payment.getEmail())
                .amount(payment.getAmount())
                .date(payment.getDate())
                .claimId(payment.getClaimId())
                .status(payment.getStatus())
                .build();
    }

    public ProductResponse getClaimByID(int id){
        //int finalId = Integer.parseInt(id);
        Optional<Product> paymentList = productRepositroy.findById(id);
        //return (ProductResponse) paymentList.stream().map(this::mapToClaimResponse).toList();
        return paymentList.map(this::mapToClaimResponse).orElse(null);
    }

    public Product updateProductsByFields(int id, Map<String, Object> fields) {
        Optional<Product> existingClaim = productRepositroy.findById(id);
        if(existingClaim.isPresent()){
        fields.forEach((key,value) ->{
            Field field = ReflectionUtils.findField(Product.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingClaim.get(), value);
        });
        return productRepositroy.save(existingClaim.get());
    }
        return null;
    }
}
