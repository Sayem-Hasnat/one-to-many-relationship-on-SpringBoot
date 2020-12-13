package com.example.assignment.controller;

import com.example.assignment.dto.DesignationDto;
import com.example.assignment.dto.EmployeeDto;
import com.example.assignment.entity.Designation;
import com.example.assignment.entity.Employee;
import com.example.assignment.repository.DesignationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/desigCon")
public class DesignationController {
    @Autowired
    private DesignationRepository repository;

    @RequestMapping("/getAllDesignation")
    String getAllDesignation(Model model) {
        System.out.println("getAll designation controller called");
        List<Designation> listOfDesignation = repository.findAll();
        model.addAttribute("designationList", listOfDesignation);
        return "designation/designation-list";
    }

    @GetMapping("/addDesignation")
    String designationAdd(Model model) {
        //sending dto object to view for form th:object
        DesignationDto designationDtobj = new DesignationDto();
        model.addAttribute("desgnationDto", designationDtobj);

        return "designation/add-designation";
    }

    @PostMapping("/save")
    String saveDesignation(@ModelAttribute DesignationDto desgnationDto) {
        Designation designation = new Designation();
        BeanUtils.copyProperties(desgnationDto, designation);
        repository.save(designation);

        return "redirect:/desigCon/getAllDesignation";
    }



}
