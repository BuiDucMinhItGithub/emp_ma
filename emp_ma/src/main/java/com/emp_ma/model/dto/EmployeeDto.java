package com.emp_ma.model.dto;

import lombok.*;

import java.util.Date;


public class EmployeeDto {
    private int id;
    private String fullname;
    private String username;
    private Date birthday;
    private String email;
    private int gender;
    private String address;
    private String password;
    private int number;
    private Date hire_date;
    private int department_id;
    private int status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public EmployeeDto(int id, String fullname, String username, Date birthday, String email, int gender, String address, String password, int number, Date hire_date, int department_id, int status) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.password = password;
        this.number = number;
        this.hire_date = hire_date;
        this.department_id = department_id;
        this.status = status;
    }

    public EmployeeDto() {
    }
}
