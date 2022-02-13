package com.emp_ma.controller;

import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("ok")
    public String getAll(Model model){
        List<EmployeeDto> employeeDtos =  employeeService.getAll();
        return "Admin/Employee/index";
    }

    @GetMapping("/{id}")
    public EmployeeDto getDetailEmployeeById(@PathVariable int id){
        return employeeService.getDetailByEmployeeId(id);
    }

    @GetMapping("/name")
    public List<EmployeeDto> getAllByName(@RequestParam String name){
        return employeeService.getEmployeesByName(name);
    }

    @GetMapping("/birthday")
    public List<EmployeeDto> getAllByBirthday(@RequestParam String birthday){
        int year = Integer.parseInt(birthday.substring(0,4));
        int month = Integer.parseInt(birthday.substring(5,7));
        int day =Integer.parseInt(birthday.substring(8,10));
        return employeeService.getEmployeesByBirthday(year,month,day);
    }

    @GetMapping("/birthday2")
    public List<EmployeeDto> getAllByMonth(@RequestParam String birthday){
        int year = Integer.parseInt(birthday.substring(0,4));
        int month = Integer.parseInt(birthday.substring(5,7));
        return employeeService.getEmployeesByMonth(month,year);
    }

    @GetMapping("/number")
    public EmployeeDto getAllByNumber(@RequestParam String number){
        return employeeService.getEmployeesByNumber(Integer.parseInt(number));
    }

    @GetMapping("/address")
    public List<EmployeeDto> getAllByAddress(@RequestParam String address){
        return employeeService.getEmployeesByAddress(address);
    }

    @GetMapping("/job")
    public List<EmployeeDto> getAllByJobId(@RequestParam int id){
        return employeeService.getAllByJobId(id);
    }

    @GetMapping("/department")
    public List<EmployeeDto> getAllByDepartmentId(@RequestParam int id){
        return employeeService.getAllByDepartmentId(id);
    }

    @PutMapping
    public void updateEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(employeeDto);
    }

    @DeleteMapping
    public void removeEmployeeById(@PathVariable int id){
        employeeService.removeEmployee(id);
    }

    @PostMapping
    public void addEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.addEmployee(employeeDto);
    }
}
