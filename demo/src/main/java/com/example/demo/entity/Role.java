package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // "USER" or "ADMIN"

    @ManyToMany(mappedBy = "roles")
    private List<User> users  = new ArrayList<>(); // Khởi tạo để tránh NullPointerException
}