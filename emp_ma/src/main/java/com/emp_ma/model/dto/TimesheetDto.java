package com.emp_ma.model.dto;

import lombok.*;

import java.util.Date;


public class TimesheetDto {
    private int id;
    private int id_employee;
    private Date date;
    private String time_start;
    private String time_end;

    public TimesheetDto(int id, int id_employee, Date date, String time_start, String time_end) {
        this.id = id;
        this.id_employee = id_employee;
        this.date = date;
        this.time_start = time_start;
        this.time_end = time_end;
    }

    public TimesheetDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }
}
