package com.emp_ma.model.dto;


public class RoleDto {
    private int id;
    private String role;

    public RoleDto(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
