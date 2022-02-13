package com.emp_ma.service.impl;

import com.emp_ma.Mapper.EmployeeMapper;
import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.model.entity.Department;
import com.emp_ma.model.entity.Employee;
import com.emp_ma.repository.DepartmentRepository;
import com.emp_ma.repository.EmployeeRepository;
import com.emp_ma.repository.JobsRepository;
import com.emp_ma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getAllByDepartmentId(int id) {
        return employeeMapper.listEntityToDto(employeeRepository.findAllByDepartment(id));
    }

    @Override
    public List<EmployeeDto> getAllByJobId(int id) {
        return employeeMapper.listEntityToDto(employeeRepository.findAllByJobId(id));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeMapper.listEntityToDto(employeeRepository.findAll());
    }

    @Override
    public EmployeeDto getDetailByEmployeeId(int id_employee) {
        return employeeMapper.entityToDto(employeeRepository.findById(id_employee));
    }

    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Department department = departmentRepository.findById(employeeDto.getDepartment_id());
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFullname(employeeDto.getFullname());
        employee.setUsername(employeeDto.getUsername());
        employee.setAddress(employeeDto.getAddress());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setPassword(employeeDto.getPassword());
        employee.setNumber(employeeDto.getNumber());
        employee.setGender(employeeDto.getGender());
        employee.setDepartment(department);
        employee.setHire_date(employeeDto.getHire_date());
        employee.setStatus(employeeDto.getStatus());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.dtoToEntity(employeeDto));
    }

    @Override
    public void removeEmployee(int id_employee) {
        Employee employee = employeeRepository.findById(id_employee);
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByName(String name) {
        return employeeMapper.listEntityToDto(employeeRepository.findAllByFullnameContains(name));
    }

    @Override
    public List<EmployeeDto> getEmployeesByMonth(int month, int year) {
        return employeeMapper.listEntityToDto(employeeRepository.findAllByBirthday(month,year));
    }

    @Override
    public List<EmployeeDto> getEmployeesByBirthday(int year, int month, int day) {
        return employeeMapper.listEntityToDto(employeeRepository.findAllByBirthday(year, month, day));
    }

    @Override
    public List<EmployeeDto> getEmployeesByAddress(String address) {
        return employeeMapper.listEntityToDto(employeeRepository.findAllByAddressContains(address));
    }

    @Override
    public EmployeeDto getEmployeesByNumber(int number) {
        return employeeMapper.entityToDto(employeeRepository.findAllByNumberContains(number));
    }

    @Override
    public EmployeeDto login(String username, String password) {
        return employeeMapper.entityToDto(employeeRepository.login(username, password));
    }
}
