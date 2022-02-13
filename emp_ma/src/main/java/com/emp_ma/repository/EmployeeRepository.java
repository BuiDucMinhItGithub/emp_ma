package com.emp_ma.repository;

import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, CrudRepository<Employee, Integer> {

    List<Employee> findAllByAddressContains(String address);

    Employee findAllByNumberContains(int number);

    @Query(value = "select  * from tbl_employee where month(birthday) = :birthday and year(birthday) = :year",nativeQuery = true)
    List<Employee> findAllByBirthday(int birthday, int year);

    @Query(value = "select  * from tbl_employee where month(birthday) = :month and year(birthday) = :year AND day(birthday) = :day",nativeQuery = true)
    List<Employee> findAllByBirthday(int year,int month, int day);

    List<Employee> findAllByFullnameContains(String name);

    @Query(value = "select * from tbl_employee where tbl_employee.department_id = :id_department",nativeQuery = true)
    List<Employee> findAllByDepartment(int id_department);

    Employee findById(int id);

    @Query(value = "Select * from tbl_employee where username = :username and password = :password",nativeQuery = true)
    Employee login(String username, String password);

    @Query(value = "Select distinct tbl_employee.id,tbl_employee.birthday,tbl_employee.password,tbl_employee.status, tbl_employee.username, tbl_employee.fullname, tbl_employee.address, tbl_employee.gender, tbl_employee.hire_date, tbl_employee.number," +
            "tbl_employee.department_id from tbl_job,tbl_employee,tbl_employee_job where tbl_job.id = tbl_employee_job.id_job and tbl_employee_job.id_employee = tbl_employee.id and tbl_job.id = :id", nativeQuery = true)
    List<Employee> findAllByJobId(int id);

    EmployeeDto findByUsername(String name);


}
