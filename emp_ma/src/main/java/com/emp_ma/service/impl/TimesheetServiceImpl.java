package com.emp_ma.service.impl;

import com.emp_ma.Mapper.TimesheetMapper;
import com.emp_ma.model.dto.TimesheetDto;
import com.emp_ma.repository.TimesheetRepository;
import com.emp_ma.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    TimesheetMapper timesheetMapper;

    @Autowired
    TimesheetRepository timesheetRepository;

    @Override
    public List<TimesheetDto> getAllByEmployeeIdAndMonth(int id_employee, String date) {
        return timesheetMapper.listEntityToDto(timesheetRepository.findAllByEmployee_idAndDateContains(id_employee,date));
    }

    @Override
    public TimesheetDto getAllByEmployeeIdAndDate(int id_employee, String date) {
        return timesheetMapper.entityToDto(timesheetRepository.findAllByEmployee_idAndDate(id_employee, date));
    }

    @Override
    public void updateTimesheet(TimesheetDto timesheetDto) {
        timesheetRepository.save(timesheetMapper.dtoToEntity(timesheetDto));
    }

    @Override
    public void removeTimesheetByEmployeeIdAndDate(int id_employee, String date) {
        TimesheetDto timesheetDto = getAllByEmployeeIdAndDate(id_employee, date);
        timesheetRepository.delete(timesheetMapper.dtoToEntity(timesheetDto));
    }
}
