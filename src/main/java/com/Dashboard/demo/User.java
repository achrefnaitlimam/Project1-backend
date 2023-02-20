package com.Dashboard.demo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Users")
public class User {
    private String name;
    private String email;
    private String pasword;
}
