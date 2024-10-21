package com.bookHubProject.orderManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "book_order")
public class Order {

    @Id
    @GeneratedValue
    Integer orderId;

    @Enumerated(EnumType.STRING) // Specify enum storage type (as VARCHAR)
    OrderStatus orderStatus;

    @Column(name = "book_id")
    private Integer bookId; // Reference to the Book ID

    public enum OrderStatus {
        ORDER_PLACED,
        ORDER_CONFIRMED,
        ORDER_CANCELLED,
    }
}