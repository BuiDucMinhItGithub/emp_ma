package com.emp_ma.Mapper;

import com.emp_ma.model.dto.JobDto;
import com.emp_ma.model.entity.Job;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {
    List<JobDto> listEntityToDto(List<Job> jobs);
    JobDto entityToDto(Job job);
    Job dtoToEntity(JobDto jobDto);
    List<Job> listDtoToEntity(List<JobDto> jobDtos);
}
