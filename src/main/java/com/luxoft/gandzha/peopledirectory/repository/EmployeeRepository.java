package com.luxoft.gandzha.peopledirectory.repository;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
