package com.makersacademy.acebook.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;

    public User( String username) {
        this.username = username;
    }

    private User() {}
}
