package com.bookHubProject.bookManagement.bean;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {
    String name;
    String author;
    String price;
}
