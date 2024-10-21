package com.bookHubProject.orderManagement.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    Integer bookId;
    String bookName;
    String bookAuthor;
    BookStatus BookStatus;

    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        RESERVED,
        OUT_OF_STOCK
    }
}