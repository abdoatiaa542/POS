package com.example.POS.controller;

import com.example.POS.Service.SalesService;
import com.example.POS.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sales")
@RestController
public class SalesController {


    @Autowired
    private SalesService salesService;




    @GetMapping("/get_sales")
    public List<Sales> getSales() {
        return this.salesService.getSales();
    }



    @GetMapping("/get_sales_by_order_id")
    public List<Sales> getSalesByOrderId(@RequestParam Integer orderId) {
        return this.salesService.getSalesByOrderId( orderId);
    }


}
