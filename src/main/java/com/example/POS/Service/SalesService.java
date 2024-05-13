package com.example.POS.Service;


import com.example.POS.dto.ProductDto;
import com.example.POS.model.Order;
import com.example.POS.model.Sales;
import com.example.POS.reposatry.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SalesService {


    @Autowired
    private SalesRepo salesRepo;

    private OrderService orderService;
    public SalesService(OrderService orderService) {
        this.orderService = orderService;
    }




    public Order saveSales(List<ProductDto> orderDto) {


        Order order = orderService.saveOrder(orderDto);

//        if (orderDto.size() == 0) {
//            return null;
//        }

        orderDto.forEach(
                o -> {
                    Sales sale = new Sales();
                    sale.setOrderId(order.getOrderId());
                    sale.setProductId(o.getProduct_id());
                    sale.setDate(new Timestamp(System.currentTimeMillis()));
                    this.salesRepo.save(sale);

                });

        return order;
    }


    public List<Sales> getSales() {
        return this.salesRepo.findAll();
    }

    public List<Sales> getSalesByOrderId(Integer orderId) {
        return this.salesRepo.findAllByOrderId(orderId);
    }


}