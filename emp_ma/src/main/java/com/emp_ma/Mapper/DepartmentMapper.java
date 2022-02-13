package com.emp_ma.Mapper;

import com.emp_ma.model.dto.DepartmentDto;
import com.emp_ma.model.entity.Department;
import org.mapstruct.Mapper;

import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);


    List<DepartmentDto> listEntityToDto(List<Department> departments);
    List<Department> listDtoToEntity(List<DepartmentDto> departmentDtos);
    Department dtoToEntity(DepartmentDto departmentDto);
    DepartmentDto entityToDto(Department department);
    @Named("DtoNoEmployee")
    DepartmentDto entityToDtoNoEmployee(Department department);
    @Named("ListDtoNoEmployee")
    List<DepartmentDto> listEntityToDtoNoEmployee(List<Department> departments);



}
