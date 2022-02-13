package com.emp_ma.controller;

import com.emp_ma.model.dto.TimesheetDto;
import com.emp_ma.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    TimesheetService timesheetService;

    @PutMapping
    public void updateTimesheet(@ModelAttribute TimesheetDto timesheetDto){
        timesheetService.updateTimesheet(timesheetDto);
    }

    @DeleteMapping()
    public void removeTimesheetByEmployeeIdAndDate(@RequestParam int id_employee, @RequestParam String date){
        timesheetService.removeTimesheetByEmployeeIdAndDate(id_employee, date);
    }

    @GetMapping()
    public TimesheetDto getAllByEmployeeIdAndDate(@RequestParam int id_employee, @RequestParam String date){
        return timesheetService.getAllByEmployeeIdAndDate(id_employee, date);
    }

    @GetMapping("/get")
    public List<TimesheetDto> getAllByEmployeeIdAndMonth(@RequestParam int id_employee, @RequestParam String month){
        return timesheetService.getAllByEmployeeIdAndMonth(id_employee, month);
    }
}
