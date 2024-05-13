package com.example.POS.Service;


import com.example.POS.dto.ProductDto;
import com.example.POS.model.Order;
import com.example.POS.reposatry.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepo orderRepo;


    public Order saveOrder(List<ProductDto> order) {
        Order order1 = new Order();
        Double total = 0.0;

        for (ProductDto o : order) {
            total += o.getProduct_price();
        }

        order1.setTotal(total);
        return orderRepo.save(order1);
    }


    public List<Order> getAllOrder() {
        return this.orderRepo.findAll();
    }


}

