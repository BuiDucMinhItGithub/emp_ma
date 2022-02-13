package com.emp_ma.service;

import com.emp_ma.model.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDto> getAllByDepartmentId(int id);
    List<EmployeeDto> getAllByJobId(int id);
    List<EmployeeDto> getAll();
    EmployeeDto getDetailByEmployeeId(int id_employee);
    void addEmployee(EmployeeDto employeeDto);
    void updateEmployee(EmployeeDto employeeDto);
    void removeEmployee(int id_employee);
    List<EmployeeDto> getEmployeesByName(String name);
    List<EmployeeDto> getEmployeesByMonth(int month, int year);
    List<EmployeeDto> getEmployeesByBirthday(int year, int month, int day);
    List<EmployeeDto> getEmployeesByAddress(String address);
    EmployeeDto getEmployeesByNumber(int number);
    EmployeeDto login(String username, String password);
}
