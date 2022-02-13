package com.emp_ma.service;

import com.emp_ma.model.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAll();
    List<RoleDto> getRolesByEmployeeId(int id_employee);
    RoleDto getDetailRoleById(int id);
    void updateRole(RoleDto roleDto);
    void removeRole(int id);
    void addRole(RoleDto roleDto);
    void removeRoleOfEmployee(int id, int id_emoloyee);
}
