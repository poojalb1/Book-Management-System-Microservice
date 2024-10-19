package com.bookHubProject.bookManagement.configuration;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
@ConfigurationProperties("book-management")
public class Configuration {
    String name;
    String author;
    String price;
}
