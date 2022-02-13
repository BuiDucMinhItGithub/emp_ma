package com.emp_ma.Mapper.Impl;

import com.emp_ma.Mapper.JobMapper;
import com.emp_ma.model.dto.JobDto;
import com.emp_ma.model.entity.Job;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobMapperImpl implements JobMapper {
    @Override
    public List<JobDto> listEntityToDto(List<Job> jobs) {
        if(jobs == null){
            return null;
        }

        List<JobDto> jobDtos = new ArrayList<>(jobs.size());
        for (Job job: jobs) {
            jobDtos.add(entityToDto(job));
        }
        return jobDtos;
    }

    @Override
    public JobDto entityToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setName(job.getName());
        jobDto.setDescription(job.getDescription());
        jobDto.setStatus(job.getStatus());
        return jobDto;
    }

    @Override
    public Job dtoToEntity(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setName(jobDto.getName());
        job.setDescription(jobDto.getDescription());
        job.setStatus(jobDto.getStatus());
        return job;
    }

    @Override
    public List<Job> listDtoToEntity(List<JobDto> jobDtos) {
        if(jobDtos == null){
            return null;
        }

        List<Job> jobs = new ArrayList<>(jobDtos.size());
        for (JobDto jobDto: jobDtos) {
            jobs.add(dtoToEntity(jobDto));
        }
        return jobs;
    }
}
