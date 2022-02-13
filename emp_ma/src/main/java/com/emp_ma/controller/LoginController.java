package com.emp_ma.controller;

import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/login")
    public EmployeeDto login(@RequestParam String username, @RequestParam String password){
        return employeeService.login(username, password);
    }

    public void logout(){

    }
}
