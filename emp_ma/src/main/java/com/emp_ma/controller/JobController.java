package com.emp_ma.controller;

import com.emp_ma.model.dto.JobDto;
import com.emp_ma.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public List<JobDto> getAll(){
        return jobService.getAll();
    }

    @GetMapping("/detail")
    public JobDto getDetailById(@RequestParam int id){
        return jobService.getDetailJobById(id);
    }

    @GetMapping("/name")
    public List<JobDto> getAllByName(@RequestParam String name){
        return jobService.getJobByName(name);
    }

    @GetMapping("/employee")
    public List<JobDto> getAllByEmployeeId(@RequestParam int id){
        return jobService.getAllByEmployeeId(id);
    }

    @GetMapping("/status")
    public List<JobDto> getAllByStatus(@RequestParam int status){
        return jobService.getAllByStatus(status);
    }

    @PutMapping
    public void updateJob(@RequestBody JobDto jobDto){
        jobService.updateJob(jobDto);
    }

    @DeleteMapping
    public void removeJob(@PathVariable int id){
        jobService.removeJob(id);
    }

    @PostMapping
    public void addJob(@RequestBody JobDto jobDto){
        jobService.addJob(jobDto);
    }
}
