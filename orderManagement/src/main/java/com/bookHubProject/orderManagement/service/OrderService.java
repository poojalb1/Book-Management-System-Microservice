package com.bookHubProject.orderManagement.service;

import com.bookHubProject.orderManagement.entity.Order;
import com.bookHubProject.orderManagement.entity.dto.BookDTO;
import com.bookHubProject.orderManagement.proxy.BookManagementProxy;
import com.bookHubProject.orderManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    BookManagementProxy proxy;

    public Order placeOrder(Order order) {

        BookDTO book = proxy.retrieveBookInfo(order.getBookId());// Fetch book details from the book service

        if (book == null || book.getBookStatus() != BookDTO.BookStatus.AVAILABLE) {
            throw new RuntimeException("Book not found or not available");
        }
        order.setOrderStatus(Order.OrderStatus.ORDER_PLACED);// Set order status
        book.setBookStatus(BookDTO.BookStatus.BORROWED); // // Update the book status to "BORROWED" ,Update the status locally
        proxy.updateBookInfo(book); // Update the book on the service
        return orderRepo.save(order);// Save the order
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
}
