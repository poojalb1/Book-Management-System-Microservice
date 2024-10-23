package com.bookHubProject.orderManagement.service;

import com.bookHubProject.orderManagement.entity.Order;
import com.bookHubProject.orderManagement.entity.dto.BookDTO;
import com.bookHubProject.orderManagement.proxy.BookManagementProxy;
import com.bookHubProject.orderManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    BookManagementProxy proxy;

    private static final String BOOK_SERVICE_URL = "http://localhost:8081/book";


    public Order placeOrder(Order order) {
        // Fetch book details from the book service
        //ResponseEntity<BookDTO> response = restTemplate.getForEntity(BOOK_SERVICE_URL + "/{id}", BookDTO.class, order.getBookId());
        BookDTO book = proxy.retrieveBookInfo(order.getBookId());

        if (book == null || book.getBookStatus() != BookDTO.BookStatus.AVAILABLE) {
            throw new RuntimeException("Book not found or not available");
        }

        // Set order status
        order.setOrderStatus(Order.OrderStatus.ORDER_PLACED);

        // Update the book status to "BORROWED"
        book.setBookStatus(BookDTO.BookStatus.BORROWED); // Update the status locally
        restTemplate.put(BOOK_SERVICE_URL, book); // Update the book on the service

        // Save the order
        return orderRepo.save(order);
    }

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
}
