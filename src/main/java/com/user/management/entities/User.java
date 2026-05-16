package com.user.management.entities;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class User {

    private int id;
    private String name;
    private String email;
    private String contact;
    private String address;
    

}
