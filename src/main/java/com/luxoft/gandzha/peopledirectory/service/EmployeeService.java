package com.luxoft.gandzha.peopledirectory.service;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import com.luxoft.gandzha.peopledirectory.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    public List<Employee> findAllByNameAndLastName(String text)  {
        List<Employee> employees = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<List<Employee>> future = (CompletableFuture<List<Employee>>) executorService.submit(() -> findAllByName(text));
        CompletableFuture<List<Employee>> submit = (CompletableFuture<List<Employee>>) executorService.submit(() -> findAllByLastName(text));
        try {
            employees.addAll(future.get());
            employees.addAll(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return employees;
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
