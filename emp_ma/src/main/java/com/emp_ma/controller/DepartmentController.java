package com.emp_ma.controller;

import com.emp_ma.model.dto.DepartmentDto;
import com.emp_ma.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping()
    public List<DepartmentDto> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/name")
    public List<DepartmentDto> getByName(@RequestParam String name){
        return departmentService.getByName(name);
    }

    @GetMapping("/{id}")
    public DepartmentDto getDetail(@PathVariable int id){
        return departmentService.getDepartmentDetailById(id);
    }

    @PutMapping()
    public void update(@RequestBody DepartmentDto departmentDto){
        departmentService.updateDepartment(departmentDto);
    }

    @PostMapping()
    public void add(@RequestBody DepartmentDto departmentDto){
        departmentService.addDepartment(departmentDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable int id){
        departmentService.removeDepartment(id);
    }
}
