package com.example.assignment.init;

import com.example.assignment.entity.Employee;
import com.example.assignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeData implements CommandLineRunner {
    @Autowired
    EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
       /* Employee employee = new Employee();
        employee.setName("Kamal");
        employee.setAge(29);
        employee.setAddress("dhk");
        employee.setDesignation("Manager");
        employee.setSalary(50000);
        employee.setType("Part Time");
        repository.save(employee);*/
    }
}
