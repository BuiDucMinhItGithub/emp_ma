package com.emp_ma.model.entity;
import javax.persistence.*;
import java.util.List;


@Table(name = "tbl_department")
@Entity
public class Department{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private  int id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private int manager_id;

    @Column(name = "rank_salary")
    private int rank_salary;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;


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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(int id, String name, int manager_id, int rank_salary, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager_id = manager_id;
        this.rank_salary = rank_salary;
        this.employees = employees;
    }

    public Department() {
    }
}
