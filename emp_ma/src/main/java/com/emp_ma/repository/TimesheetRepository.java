package com.emp_ma.repository;

import com.emp_ma.model.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

    List<Timesheet> findAllByEmployee_idAndDateContains(int id_employee, String date);
    Timesheet findAllByEmployee_idAndDate(int id_employee, String date);
}
