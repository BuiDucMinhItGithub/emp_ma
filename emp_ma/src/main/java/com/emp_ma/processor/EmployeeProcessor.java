package com.emp_ma.processor;

import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.model.entity.Employee;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeProcessor implements ItemProcessor<Employee, EmployeeDto> {
    @Override
    public EmployeeDto process(Employee employee) throws Exception {
        System.out.println("Transforming Employee(s) to EmployeeDTO(s)..");
        final EmployeeDto empployeeDto = new EmployeeDto(employee.getId(), employee.getFullname(),employee.getUsername(),
                employee.getBirthday(),employee.getEmail(), employee.getGender(),employee.getPassword(),employee.getAddress(),employee.getNumber()
                ,employee.getHire_date(), employee.getStatus(),employee.getDepartment().getId());

        return empployeeDto;
    }
}
