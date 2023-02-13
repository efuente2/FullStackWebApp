package com.mtit.microservice.documentservice.documentservice.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String Title;

    @Column(name = "price")
    private int Price;

    @Column(name = "category")
    public String Category;

    @Column(name = "description")
    public String Description;

    @Column(name = "image")
    public String image;

    public String getDescription() {return Description;}

    public int getId(){return id;}

    public  String getTitle(){
        return Title;
    }

    public int getPrice(){return Price;}

    public String getCategory(){return Category;}

    public String getImage(){return image;}



}
