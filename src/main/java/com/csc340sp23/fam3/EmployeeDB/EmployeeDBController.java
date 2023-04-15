package com.csc340sp23.fam3.EmployeeDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 최연서
 */
@Controller
@RequestMapping("/employeeDB")
public class EmployeeDBController {
    
    @Autowired
    private EmployeeDBService service;

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        model.addAttribute("employeeDBList", service.getAllEmployees());
        return "fam/a_database";
    }

    @GetMapping("/id={id}")
    public String getEmployee(@PathVariable long id, Model model) {
        model.addAttribute("employeeDB", service.getEmployee(id));
        return "fam/employee_detail";
    }

    @GetMapping("/delete/id={id}")
    public String deleteEmployee(@PathVariable long id, Model model) {
        service.deleteEmployee(id);
        return "redirect:/employeeDB/all";
    }

    @PostMapping("/create")
    public String createEmployee(EmployeeDB employee) {
        service.saveEmployee(employee);
        return "redirect:/employeeDB/all";
    }

    @PostMapping("/update")
    public String upateEmployee(EmployeeDB employee) {
        service.updateEmployee(employee);
        return "redirect:/employeeDB/all";
    }

    @GetMapping("/new-employee")
    public String newEmloyeeForm(Model model) {
        return "fam/add_employee";
    }

    @GetMapping("/update/id={id}")
    public String updateEmployeeForm(@PathVariable long id, Model model) {
        model.addAttribute("employeeDB", service.getEmployee(id));
        return "fam/edit_employee";
    }
}
