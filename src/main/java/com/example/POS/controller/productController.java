package com.example.POS.controller;


import com.example.POS.Service.ProductService;
import com.example.POS.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class productController {


    @Autowired
    private ProductService productService;


    @PostMapping("/add_product")
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }


    @GetMapping("/delete_product")
    public String deleteProduct(@RequestParam Integer id) {
        productService.deleteProduct(id);
        return "Successfully Deleted Product";
    }

    @PutMapping ("/update_product")
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    // return (emptiness)
    @GetMapping("/get_product_by_barcode")
    public Product getProductByBarcode(@RequestParam String barcode) {
        return this.productService.getProductByBarcode(barcode);
    }

    @GetMapping("/get_product_by_id")
    public Product getProductById(@RequestParam Integer id) {
        return this.productService.getProductById(id);
    }

    @GetMapping("/get_all_products")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }


}
