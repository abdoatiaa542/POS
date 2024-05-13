package com.example.POS.Service;

import com.example.POS.model.Product;
import com.example.POS.reposatry.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepo productRepo;


    public Product addProduct(Product product) {
        return this.productRepo.save(product);
    }


    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    public Product getProductByBarcode(String barcode) {
        Optional<Product> o = Optional.ofNullable(productRepo.findByBarCode(barcode));
        if (o.isPresent()) {
            return o.get();
        } else {
            return null;
        }

    }


    public Product getProductById(Integer id) {
        Optional<Product> o = productRepo.findById(id);
        if (o.isPresent()) {
            return o.get();
        } else {
            return null;
        }
    }



    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }


}
