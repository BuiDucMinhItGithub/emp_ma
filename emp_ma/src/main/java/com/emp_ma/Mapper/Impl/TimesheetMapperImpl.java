package com.emp_ma.Mapper.Impl;

import com.emp_ma.Mapper.TimesheetMapper;
import com.emp_ma.model.dto.TimesheetDto;
import com.emp_ma.model.entity.Timesheet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimesheetMapperImpl implements TimesheetMapper {
    @Override
    public List<TimesheetDto> listEntityToDto(List<Timesheet> timesheets) {
        if(timesheets == null){
            return null;
        }

        List<TimesheetDto> timesheetDtos = new ArrayList<>(timesheets.size());
        for (Timesheet timesheet:timesheets) {
            timesheetDtos.add(entityToDto(timesheet));
        }
        return timesheetDtos;
    }

    @Override
    public List<Timesheet> listDtoToEntity(List<TimesheetDto> timesheetDtos) {
        if(timesheetDtos == null){
            return null;
        }

        List<Timesheet> timesheets = new ArrayList<>(timesheetDtos.size());
        for (TimesheetDto timesheetDto: timesheetDtos) {
            timesheets.add(dtoToEntity(timesheetDto));
        }
        return timesheets;
    }

    @Override
    public Timesheet dtoToEntity(TimesheetDto timesheetDto) {
        Timesheet timesheet = new Timesheet();
        timesheet.setId(timesheetDto.getId());
        timesheet.setEmployee_id(timesheetDto.getId_employee());
        timesheet.setDate(timesheetDto.getDate());
        timesheet.setTime_start(timesheetDto.getTime_start());
        timesheet.setTime_end(timesheetDto.getTime_end());
        return timesheet;
    }

    @Override
    public TimesheetDto entityToDto(Timesheet timesheet) {
        TimesheetDto timesheetDto = new TimesheetDto();
        timesheetDto.setId(timesheet.getId());
        timesheetDto.setId_employee(timesheet.getEmployee_id());
        timesheetDto.setDate(timesheet.getDate());
        timesheetDto.setTime_start(timesheet.getTime_start());
        timesheetDto.setTime_end(timesheet.getTime_end());
        return timesheetDto;
    }
}
