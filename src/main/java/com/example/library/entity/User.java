package com.example.library.entity;

import jakarta.persistence.Entity;

/**
 * @author Yurii_Suprun
 */
@Entity
public class User {

    private long id;
    private String username;
    private String password;
    private Role role;
    private String email;
}
