package com.emp_ma.controller;

import com.emp_ma.model.dto.RoleDto;
import com.emp_ma.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping
    public void addRole(@RequestBody RoleDto roleDto){
        roleService.addRole(roleDto);
    }

    @PutMapping
    public void updateRole(@RequestBody RoleDto roleDto){
        roleService.updateRole(roleDto);
    }

    @DeleteMapping
    public void removeRole(@PathVariable int id){
        roleService.removeRole(id);
    }

    @DeleteMapping("/delete")
    public void removeRoleByEmployeeIdAndRoleId(@RequestParam int id_role, @RequestParam int id_employee){
        roleService.removeRoleOfEmployee(id_role, id_employee);
    }

    @GetMapping
    public List<RoleDto> getAll(){
        return roleService.getAll();
    }

    @GetMapping("/employee")
    public List<RoleDto> getAllByEmployeeId(@RequestParam int id){
        return roleService.getRolesByEmployeeId(id);
    }


}
