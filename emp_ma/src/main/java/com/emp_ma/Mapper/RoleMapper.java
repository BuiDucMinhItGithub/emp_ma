package com.emp_ma.Mapper;

import com.emp_ma.model.dto.RoleDto;
import com.emp_ma.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<RoleDto> listEntityToDto(List<Role> roles);
    List<Role> listDtoToEntity(List<RoleDto> roleDtos);
    Role dtoToEntity(RoleDto roleDto);
    RoleDto entityToDto(Role role);
}
