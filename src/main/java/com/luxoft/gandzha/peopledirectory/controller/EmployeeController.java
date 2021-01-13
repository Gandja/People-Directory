package com.luxoft.gandzha.peopledirectory.controller;

import com.luxoft.gandzha.peopledirectory.model.Employee;
import com.luxoft.gandzha.peopledirectory.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RestController
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employee")
    public String create(@RequestBody @Valid Employee employee) {
        service.save(employee);
        return "Employee was created";
    }

    @DeleteMapping("/employee")
    public String delete(@RequestParam @Valid Long id) {
        service.delete(id);
        return "Employee was deleted";
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        List<Employee> employees = service.findAll();
        return employees;
    }

    @GetMapping("/employee")
    public Employee findByName(@RequestParam("name") @NotNull String name) {
        Employee employee = service.findByName(name);
        return employee;
    }

    @GetMapping("/employees/all")
    public List<Employee> findAllByNameAndLastName(@RequestParam("text") @NotNull String text) throws ExecutionException, InterruptedException {
        List<Employee> employees = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Employee>> future = executorService.submit(() -> service.findAllByName(text));
        Future<List<Employee>> submit = executorService.submit(() -> service.findAllByLastName(text));
        employees.addAll(future.get());
        employees.addAll(submit.get());
        return employees;
    }
}
