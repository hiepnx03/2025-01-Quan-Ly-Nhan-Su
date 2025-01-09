package com.example.demo.dto;


public class RoleDTO {
    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }

    public RoleDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
