package com.example.POS.dto;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ProductDto {


    private Integer product_id;
    private Double product_price  ;


}
