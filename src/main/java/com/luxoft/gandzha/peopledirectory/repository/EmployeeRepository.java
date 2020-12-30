package com.luxoft.gandzha.peopledirectory.repository;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);

    public List<Employee> findAllByName(Example<String> name);
}
