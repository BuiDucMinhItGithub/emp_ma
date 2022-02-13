package com.emp_ma.service;


import com.emp_ma.model.dto.DepartmentDto;
import java.util.List;


public interface DepartmentService {
    List<DepartmentDto> getAll();
    DepartmentDto getDepartmentDetailById(int id);
    void updateDepartment(DepartmentDto departmentDto);
    void removeDepartment(int id);
    void addDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getByName(String name);
}
