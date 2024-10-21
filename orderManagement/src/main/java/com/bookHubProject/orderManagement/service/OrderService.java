package com.bookHubProject.orderManagement.service;

import com.bookHubProject.orderManagement.entity.Order;
import com.bookHubProject.orderManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    public Order placeOrder(Order order){
        return orderRepo.save(order);
    }

    public List<Order> getOrders(){
        return orderRepo.findAll();
    }
}
