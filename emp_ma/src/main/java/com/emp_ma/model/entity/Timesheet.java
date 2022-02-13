package com.emp_ma.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tbl_timesheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "id_employee")
    private int employee_id;
    @Column(name = "date")
    private Date date;
    @Column(name = "time_start")
    private String time_start;
    @Column(name = "time_end")
    private String time_end;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Timesheet(int id, int employee_id, Date date, String time_start, String time_end, Employee employee) {
        this.id = id;
        this.employee_id = employee_id;
        this.date = date;
        this.time_start = time_start;
        this.time_end = time_end;
        this.employee = employee;
    }



    public Timesheet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
