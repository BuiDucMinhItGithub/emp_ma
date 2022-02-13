package com.emp_ma.repository;

import com.emp_ma.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {

    Job findById(int id);


    List<Job> findAllByStatusEquals(int status);

    List<Job> findAllByNameContains(String name);

    @Query(value = "select c FROM Job c JOIN c.employees u WHERE u.id = :id")
    List<Job> findByEmployeeId(int id);

}
