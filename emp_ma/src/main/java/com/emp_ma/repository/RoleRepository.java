package com.emp_ma.repository;

import com.emp_ma.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findById(int id);

    @Query(value = "select c FROM Role c JOIN c.employees u WHERE u.id = :id")
    List<Role> findByEmployeeId(int id);

    @Query(value = "delete from tbl_employee_role where id_job = :id_job AND id_employee = :id_employee",nativeQuery = true)
    void deleteByEmployeeIdAndJobId(int id_job, int id_employee);
}
