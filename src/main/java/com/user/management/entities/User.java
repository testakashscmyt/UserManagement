package com.user.management.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    private int id;
    private String name;
    private String email;
    private String contact;
    private String address;
    

}
