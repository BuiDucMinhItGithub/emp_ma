package com.emp_ma.service.impl;

import com.emp_ma.Mapper.RoleMapper;
import com.emp_ma.model.dto.RoleDto;
import com.emp_ma.repository.RoleRepository;
import com.emp_ma.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDto> getAll() {
        return roleMapper.listEntityToDto(roleRepository.findAll());
    }

    @Override
    public List<RoleDto> getRolesByEmployeeId(int id_employee) {
        return roleMapper.listEntityToDto(roleRepository.findByEmployeeId(id_employee));
    }

    @Override
    public RoleDto getDetailRoleById(int id) {
        return roleMapper.entityToDto(roleRepository.findById(id));
    }

    @Override
    public void updateRole(RoleDto roleDto) {
        roleRepository.save(roleMapper.dtoToEntity(roleDto));
    }

    @Override
    public void removeRole(int id) {
        RoleDto roleDto = getDetailRoleById(id);
        roleRepository.delete(roleMapper.dtoToEntity(roleDto));
    }

    @Override
    public void addRole(RoleDto roleDto) {
        roleRepository.save(roleMapper.dtoToEntity(roleDto));
    }

    @Override
    public void removeRoleOfEmployee(int id, int id_emoloyee) {
        roleRepository.deleteByEmployeeIdAndJobId(id,id_emoloyee);
    }
}
