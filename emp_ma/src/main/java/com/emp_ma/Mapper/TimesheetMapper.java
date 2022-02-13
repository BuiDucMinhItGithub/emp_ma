package com.emp_ma.Mapper;

import com.emp_ma.model.dto.TimesheetDto;
import com.emp_ma.model.entity.Timesheet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TimesheetMapper {
    List<TimesheetDto> listEntityToDto(List<Timesheet> timesheets);
    List<Timesheet> listDtoToEntity(List<TimesheetDto> timesheetDtos);
    Timesheet dtoToEntity(TimesheetDto timesheetDto);
    TimesheetDto entityToDto(Timesheet timesheet);
}
