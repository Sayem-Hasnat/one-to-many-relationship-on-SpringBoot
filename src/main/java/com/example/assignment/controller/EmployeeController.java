package com.example.assignment.controller;

import com.example.assignment.dto.DesignationDto;
import com.example.assignment.dto.EmployeeDto;
import com.example.assignment.entity.Designation;
import com.example.assignment.entity.Employee;
import com.example.assignment.repository.DesignationRepository;
import com.example.assignment.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empController")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private DesignationRepository designationRepo;

    @RequestMapping("/getAllEmployee")
    String getAllEmployee(Model model) {
        List<Employee> listOfEmployee = repository.findAll();
        model.addAttribute("employeeList", listOfEmployee);
        return "employee/employee-list";
    }

    @GetMapping("/employeeAddPage")
    String employeeAddPage(Model model) {
        //sending dto object to view for form th:object
        EmployeeDto employeeDtoObj = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDtoObj);

        // send designation list for form
        List<Designation> listOfDesignation = designationRepo.findAll();
        List<DesignationDto> listOfDesignationDto = new ArrayList<>();

        for (Designation designation:listOfDesignation) {
            DesignationDto designationDto = new DesignationDto();
            BeanUtils.copyProperties(designation,designationDto);
            listOfDesignationDto.add(designationDto);
        }

        model.addAttribute("designationListDto", listOfDesignationDto);

        //send Type list for form
        List<String> listOfType = new ArrayList<>();
        listOfType.add("Part Time");
        listOfType.add("Full Time");
        model.addAttribute("typeList", listOfType);
        return "employee/add-employee";
    }

    @PostMapping("/save")
    String saveEmployee(@ModelAttribute EmployeeDto employeeDto) {

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        employee.setDesignation(designationRepo.getOne(employeeDto.getDesignationId()));

        repository.save(employee);

        return "redirect:/empController/getAllEmployee";
    }

    //catch id by path variable and delete by id
    @GetMapping("/delete/{id}")
    String deleteEmployee(@PathVariable("id") long id) {
        repository.deleteById(id);
        return "redirect:/empController/getAllEmployee";
    }

    //catch id by path variable and update by id
    @GetMapping("/update/{id}")
    String updateEmployee(@PathVariable("id") long id,Model model) {
        Optional<Employee> optionalEmployee = repository.findById(id);
      Employee employee = optionalEmployee.get();
      EmployeeDto employeeDto = new EmployeeDto();
      BeanUtils.copyProperties(employee,employeeDto);
      model.addAttribute("employeeDto",employeeDto);

        // send designation list for form
        List<Designation> listOfDesignation = designationRepo.findAll();
        List<DesignationDto> listOfDesignationDto = new ArrayList<>();

        for (Designation designation:listOfDesignation) {
            DesignationDto designationDto = new DesignationDto();
            BeanUtils.copyProperties(designation,designationDto);
            listOfDesignationDto.add(designationDto);
        }

        model.addAttribute("designationListDto", listOfDesignationDto);

        //send Type list for form
        List<String> listOfType = new ArrayList<>();
        listOfType.add("Part Time");
        listOfType.add("Full Time");
        model.addAttribute("typeList", listOfType);
        return "employee/add-employee";
    }
}
