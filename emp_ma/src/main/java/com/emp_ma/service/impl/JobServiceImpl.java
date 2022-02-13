package com.emp_ma.service.impl;

import com.emp_ma.Mapper.JobMapper;
import com.emp_ma.model.dto.JobDto;
import com.emp_ma.repository.JobsRepository;
import com.emp_ma.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobMapper jobMapper;

    @Autowired
    JobsRepository jobsRepository;

    @Override
    public List<JobDto> getAll() {
        return jobMapper.listEntityToDto(jobsRepository.findAll());
    }

    @Override
    public List<JobDto> getAllByStatus(int status) {
        return jobMapper.listEntityToDto(jobsRepository.findAllByStatusEquals(1));
    }

    @Override
    public List<JobDto> getAllByEmployeeId(int id) {
        return jobMapper.listEntityToDto(jobsRepository.findByEmployeeId(id));
    }

    @Override
    public List<JobDto> getJobByName(String name) {
        return jobMapper.listEntityToDto(jobsRepository.findAllByNameContains(name));
    }

    @Override
    public JobDto getDetailJobById(int id) {
        return jobMapper.entityToDto(jobsRepository.findById(id));
    }

    @Override
    public void updateJob(JobDto jobDto) {
        jobsRepository.save(jobMapper.dtoToEntity(jobDto));
    }

    @Override
    public void removeJob(int id) {
        JobDto jobDto = getDetailJobById(id);
        jobsRepository.delete(jobMapper.dtoToEntity(jobDto));
    }

    @Override
    public void addJob(JobDto jobDto) {
        jobsRepository.save(jobMapper.dtoToEntity(jobDto));
    }
}
