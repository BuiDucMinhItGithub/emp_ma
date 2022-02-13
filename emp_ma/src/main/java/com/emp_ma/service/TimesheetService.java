package com.emp_ma.service;

import com.emp_ma.model.dto.TimesheetDto;

import java.util.List;

public interface TimesheetService {
    List<TimesheetDto> getAllByEmployeeIdAndMonth(int id_employee, String date);
    TimesheetDto getAllByEmployeeIdAndDate(int id_employee, String date);
    void updateTimesheet(TimesheetDto timesheetDto);
    void removeTimesheetByEmployeeIdAndDate(int id_employee, String date);
}
