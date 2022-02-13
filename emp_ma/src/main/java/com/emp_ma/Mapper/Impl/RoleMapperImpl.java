package com.emp_ma.Mapper.Impl;

import com.emp_ma.Mapper.RoleMapper;
import com.emp_ma.model.dto.RoleDto;
import com.emp_ma.model.entity.Role;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public List<RoleDto> listEntityToDto(List<Role> roles) {
        if(roles == null){
            return null;
        }

        List<RoleDto> roleDtos = new ArrayList<>(roles.size());
        for (Role role: roles) {
            roleDtos.add(entityToDto(role));
        }
        return roleDtos;
    }

    @Override
    public List<Role> listDtoToEntity(List<RoleDto> roleDtos) {
        if(roleDtos == null){
            return null;
        }

        List<Role> roles = new ArrayList<>(roleDtos.size());
        for (RoleDto roledto: roleDtos) {
            roles.add(dtoToEntity(roledto));
        }
        return roles;
    }

    @Override
    public Role dtoToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRole(roleDto.getRole());
        return role;
    }

    @Override
    public RoleDto entityToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());
        return roleDto;
    }
}
