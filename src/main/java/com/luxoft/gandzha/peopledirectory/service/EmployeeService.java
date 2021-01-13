package com.luxoft.gandzha.peopledirectory.service;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import com.luxoft.gandzha.peopledirectory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public void delete(Long id) {
        repository.delete(repository.getOne(id));
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee findByName(String name) {
        return repository.findByName(name);
    }

    public List<Employee> findAllByLastName(String lastName) {
        return repository.findAllByLastName(lastName);
    }

    public List<Employee> findAllByName(String name) {
        return repository.findAllByName(name);
    }

    public Employee findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Employee findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }

    public List<Employee> findAllByPosition(String position) {
        return repository.findAllByPosition(position);
    }

}
