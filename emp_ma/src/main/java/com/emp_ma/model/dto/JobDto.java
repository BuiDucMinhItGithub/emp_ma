package com.emp_ma.model.dto;


public class JobDto {
    private int id;
    private String name;
    private String description;
    private int status;

    public JobDto(int id, String name, String description, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public JobDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
