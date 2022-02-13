package com.emp_ma.service.impl;

import com.emp_ma.Mapper.DepartmentMapper;
import com.emp_ma.model.dto.DepartmentDto;
import com.emp_ma.model.entity.Department;
import com.emp_ma.repository.DepartmentRepository;
import com.emp_ma.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public List<DepartmentDto> getAll() {
        return departmentMapper.listEntityToDtoNoEmployee(departmentRepository.findAll());
    }

    @Override
    public DepartmentDto getDepartmentDetailById(int id) {
        return departmentMapper.entityToDto(departmentRepository.findById(id));
    }

    @Override
    public void updateDepartment(DepartmentDto departmentDto) {
        departmentRepository.save(departmentMapper.dtoToEntity(departmentDto));
    }

    @Override
    public void removeDepartment(int id) {
        Department department = departmentRepository.findById(id);
        departmentRepository.delete(department);
    }

    @Override
    public void addDepartment(DepartmentDto departmentDto) {
        departmentRepository.save(departmentMapper.dtoToEntity(departmentDto));
    }

    @Override
    public List<DepartmentDto> getByName(String name) {
        return departmentMapper.listEntityToDto(departmentRepository.findAllByNameContains(name));
    }
}
