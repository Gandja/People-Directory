package com.luxoft.gandzha.peopledirectory.service;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import com.luxoft.gandzha.peopledirectory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public void delete(Employee employee) {
        repository.delete(repository.findByName(employee.getName()));
    }

    public List<Employee> findAll() {
        List<Employee> employees = repository.findAll();
        return employees;
    }

    public Employee findByName(String name) {
        Employee employee = repository.findByName(name);
        return employee;
    }

    public List<Employee> findAllByLastName(String lastName) {
        List<Employee> employees = repository.findAllByLastName(lastName);
        return employees;
    }

    public List<Employee> findAllByName(String name) {
        List<Employee> employees = repository.findAllByName(name);
        return employees;
    }

   /* public List<Employee> findAllByNameOrLastName(String name, String lastName){
        List<Employee> employees = repository.findAllByNameOrLastName(name, lastName);
        return employees;
    }*/

}
