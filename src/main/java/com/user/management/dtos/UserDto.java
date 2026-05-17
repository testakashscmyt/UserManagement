package com.user.management.dtos;

import com.user.management.entities.Provider;
import com.user.management.entities.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {


    private UUID id;

    private String name;
    private String email;
    private String password;
    private String image;
    private boolean isEnabled = true;
    private String contact;
    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();
    private Provider provider = Provider.LOCAL;
    private Set<RoleDto> roles = new HashSet<>();

}


