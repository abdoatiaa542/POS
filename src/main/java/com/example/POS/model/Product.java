package com.example.POS.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "products")
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price" )
    private Double productPrice ;

    @Column(name = "barcode")
    private  String barCode;



    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Sales> sales;

}
