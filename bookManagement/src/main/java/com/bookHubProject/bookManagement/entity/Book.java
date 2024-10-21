package com.bookHubProject.bookManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue
    Integer bookId;

    String bookName;
    String bookAuthor;

    @Enumerated(EnumType.STRING) // Specify enum storage type (as VARCHAR)
    BookStatus BookStatus;

    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        RESERVED,
        OUT_OF_STOCK
    }
}


