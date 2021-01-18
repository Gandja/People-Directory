package com.luxoft.gandzha.peopledirectory.repository;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByName(String name);

    @Override
    Optional<Employee> findById(Long id);

    List<Employee> findAllByName(String name);

    List<Employee> findAllByLastName(String lastName);

    Employee findByEmail(String email);

    Employee findByPhoneNumber(String phoneNumber);

    List<Employee> findAllByPosition(String position);

}
