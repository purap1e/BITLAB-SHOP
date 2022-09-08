package com.example.demo.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logins {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private int itemsCount;

    public Logins(Long id, String email,String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }
}
