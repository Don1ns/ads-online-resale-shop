package me.don1ns.adsonlineresaleshop.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String image;
}
