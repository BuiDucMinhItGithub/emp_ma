package com.emp_ma.service;

import com.emp_ma.model.dto.JobDto;

import java.util.List;

public interface JobService {
    List<JobDto> getAll();
    List<JobDto> getAllByStatus(int status);
    List<JobDto> getAllByEmployeeId(int id);
    List<JobDto> getJobByName(String name);
    JobDto getDetailJobById(int id);
    void updateJob(JobDto jobDto);
    void removeJob(int id);
    void addJob(JobDto jobDto);
}
