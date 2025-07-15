package com.example.deploy.models;

import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private String name;
    private String email;
    private String userName;
    private String password;
    private Set<String> roleNames; // These should match values like "ADMIN", "USER"
}
