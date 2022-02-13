package com.emp_ma.repository;

import com.emp_ma.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findById(int id);
    List<Department> findAllByNameContains(String name);
}
