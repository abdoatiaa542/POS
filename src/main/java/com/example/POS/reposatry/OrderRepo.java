package com.example.POS.reposatry;

import com.example.POS.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {



}
