package com.emp_ma.Mapper.Impl;

import com.emp_ma.Mapper.DepartmentMapper;
import com.emp_ma.Mapper.EmployeeMapper;
import com.emp_ma.model.dto.DepartmentDto;
import com.emp_ma.model.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public List<DepartmentDto> listEntityToDto(List<Department> departments) {
        if (departments == null) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>(departments.size());
        for (Department department : departments) {
            list.add(entityToDto(department));
        }
        return list;
    }

    @Override
    public List<Department> listDtoToEntity(List<DepartmentDto> departmentDtos) {
        if(departmentDtos == null){
            return null;
        }

        List<Department> departments = new ArrayList<>(departmentDtos.size());
        for (DepartmentDto departmentDto: departmentDtos) {
            departments.add(dtoToEntity(departmentDto));
        }
        return departments;
    }

    @Override
    public Department dtoToEntity(DepartmentDto departmentDto) {
        if(departmentDto == null){
            return null;
        }
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        department.setManager_id(departmentDto.getManager_id());
        department.setRank_salary(departmentDto.getRank_salary());
        department.setEmployees(employeeMapper.listDtoToEntity(departmentDto.getEmployeeDtos()));
        return department;
    }


    @Override
    public DepartmentDto entityToDto(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setManager_id(department.getManager_id());
        departmentDto.setName(department.getName());
        departmentDto.setRank_salary(department.getRank_salary());
        departmentDto.setEmployeeDtos(employeeMapper.listEntityToDto(department.getEmployees()));
        return departmentDto;
    }

    @Override
    public DepartmentDto entityToDtoNoEmployee(Department department) {
        if (department == null) {
            return null;
        }
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setManager_id(department.getManager_id());
        departmentDto.setName(department.getName());
        departmentDto.setRank_salary(department.getRank_salary());
        departmentDto.setEmployeeDtos(null);
        return departmentDto;
    }

    @Override
    public List<DepartmentDto> listEntityToDtoNoEmployee(List<Department> departments) {
        if (departments == null) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>(departments.size());
        for (Department department : departments) {
            list.add(entityToDtoNoEmployee(department));
        }
        return list;
    }


}
