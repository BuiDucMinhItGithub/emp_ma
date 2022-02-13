package com.emp_ma.Mapper.Impl;

import com.emp_ma.Mapper.EmployeeMapper;
import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.model.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public EmployeeDto entityToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFullname(employee.getFullname());
        employeeDto.setUsername(employee.getUsername());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setBirthday(employee.getBirthday());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setNumber(employee.getNumber());
        employeeDto.setDepartment_id(employeeDto.getDepartment_id());
        employeeDto.setGender(employee.getGender());
        employeeDto.setHire_date(employee.getHire_date());
        employeeDto.setPassword(employee.getPassword());
        employeeDto.setStatus(employee.getStatus());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> listEntityToDto(List<Employee> employees) {
        if(employees == null){
            return null;
        }
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee: employees) {
            employeeDtos.add(entityToDto(employee));
        }
        return employeeDtos;
    }

    @Override
    public List<Employee> listDtoToEntity(List<EmployeeDto> employeeDtos) {
        if(employeeDtos == null){
            return null;
        }

        List<Employee> employees = new ArrayList<>(employeeDtos.size());
        for (EmployeeDto employeeDto: employeeDtos) {
            employees.add(dtoToEntity(employeeDto));
        }
        return employees;
    }

    @Override
    public Employee dtoToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFullname(employeeDto.getFullname());
        employee.setUsername(employeeDto.getUsername());
        employee.setAddress(employeeDto.getAddress());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(employeeDto.getPassword());
        employee.setNumber(employeeDto.getNumber());
        employee.setGender(employeeDto.getGender());
        employee.setDepartment(employee.getDepartment());
        employee.setHire_date(employeeDto.getHire_date());
        employee.setStatus(employeeDto.getStatus());
        return employee;
    }
}
