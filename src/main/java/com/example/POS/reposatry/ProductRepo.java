package com.example.POS.reposatry;

import com.example.POS.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {



    Product findByBarCode(String barCode);


}
