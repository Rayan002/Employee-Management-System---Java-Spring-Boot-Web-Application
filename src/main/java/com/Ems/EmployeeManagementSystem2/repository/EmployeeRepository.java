package com.Ems.EmployeeManagementSystem2.repository;

import com.Ems.EmployeeManagementSystem2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT COUNT(*) FROM employee WHERE role = 'developer'", nativeQuery = true)
    long countDevelopers();


    @Query(value = "SELECT COUNT(*) FROM employee WHERE role = 'designer'", nativeQuery = true)
    long countDisigners();


    @Modifying
    @Query(value = "DELETE FROM Employee e WHERE e.id = :id")
    @Transactional
    void deleteEmployeeById(@Param("id") Long id);



}
