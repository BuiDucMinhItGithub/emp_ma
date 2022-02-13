package com.emp_ma.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class DepartmentDto {
    private int id;
    private String name;
    private int manager_id;
    private int rank_salary;
    private List<EmployeeDto> employeeDtos;

    public DepartmentDto(int id, String name, int manager_id, int rank_salary, List<EmployeeDto> employeeDtos) {
        this.id = id;
        this.name = name;
        this.manager_id = manager_id;
        this.rank_salary = rank_salary;
        this.employeeDtos = employeeDtos;
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

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getRank_salary() {
        return rank_salary;
    }

    public void setRank_salary(int rank_salary) {
        this.rank_salary = rank_salary;
    }

    public List<EmployeeDto> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(List<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }

    public DepartmentDto() {
    }
}
