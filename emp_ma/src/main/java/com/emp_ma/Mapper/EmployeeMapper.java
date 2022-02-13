package com.emp_ma.Mapper;

import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.model.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface EmployeeMapper {
    EmployeeDto entityToDto(Employee employee);
    List<EmployeeDto> listEntityToDto(List<Employee> employees);
    List<Employee> listDtoToEntity(List<EmployeeDto> employeeDtos);
    Employee dtoToEntity(EmployeeDto employeeDto);
}
