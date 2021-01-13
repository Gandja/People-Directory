package com.luxoft.gandzha.peopledirectory.controller;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import com.luxoft.gandzha.peopledirectory.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employee")
    public void create(@Valid @RequestBody Employee employee) {
        service.save(employee);
    }

    @DeleteMapping("/employee")
    public void delete(Long id) {
        service.delete(id);
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        List<Employee> employees = service.findAll();
        return employees;
    }

    @GetMapping("/employee")
    public Employee findByName(@NotNull @RequestParam("name") String name) {
        Employee employee = service.findByName(name);
        return employee;
    }

    @GetMapping("/employees/all")
    public List<Employee> findAllByNameAndLastName(@NotNull @RequestParam("text") String text) {
        List<Employee> employees = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() ->
                        employees.addAll(service.findAllByLastName(text)),
                employees.addAll(service.findAllByName(text)));

        return employees;
    }
}
