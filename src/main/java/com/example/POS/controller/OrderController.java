package com.example.POS.controller;


import com.example.POS.Service.OrderService;
import com.example.POS.Service.SalesService;
import com.example.POS.dto.ProductDto;
import com.example.POS.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private SalesService saleService;


    @PostMapping("/save_orders")
    public Order saveOrder(@RequestBody List<ProductDto> orderDto) {
        return this.saleService.saveSales(orderDto);
    }


    @GetMapping("/get_orders")
    public List<Order> getAllOrder() {
        return this.orderService.getAllOrder();
    }

}