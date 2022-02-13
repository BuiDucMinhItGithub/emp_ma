package com.emp_ma.model.entity;


import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tbl_employee")
public class Employee{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "username")
    private String username;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private int gender;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "number")
    private int number;
    @Column(name = "hire_date")
    private Date hire_date;
    @Column(name = "status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Timesheet> timesheets = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_employee_role", joinColumns = @JoinColumn(name = "id_employee"), inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_employee_job", joinColumns = @JoinColumn(name = "id_employee"), inverseJoinColumns = @JoinColumn(name = "id_job"))
    private List<Job> jobs;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Timesheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(List<Timesheet> timesheets) {
        this.timesheets = timesheets;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Employee(int id, String fullname, String username, Date birthday, String email, int gender, String password, String address, int number, Date hire_date, int status, Department department, List<Timesheet> timesheets, List<Role> roles, List<Job> jobs) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.address = address;
        this.number = number;
        this.hire_date = hire_date;
        this.status = status;
        this.department = department;
        this.timesheets = timesheets;
        this.roles = roles;
        this.jobs = jobs;
    }

    public Employee() {
    }
}
