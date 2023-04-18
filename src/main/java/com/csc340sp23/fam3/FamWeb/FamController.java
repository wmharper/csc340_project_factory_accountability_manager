package com.csc340sp23.fam3.FamWeb;

import com.csc340sp23.fam3.EmployeeDB.EmployeeDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.csc340sp23.fam3.Inspection.*;


/**
 *
 * @author Billy
 */
@Controller
@RequestMapping("/fam")

public class FamController {
    
    @Autowired
    FamService famService;
    @Autowired
    private EmployeeDBService dbservice;
    
    @GetMapping({"/" , "/all", "/hello"})
    public String goHome(Model model) {
        return "fam/home";
    }
    
    @GetMapping("/admin_msg")
    public String goAdminMSG(Model model) {
        return "fam/a_sendmsg";
    }
    
    @GetMapping({"/admin", "/administrator"})
    public String goAdmin(Model model) {
        return "fam/admin";
    }
    
    @GetMapping("/employee")
    public String goEmployee(Model model) {
        
        model.addAttribute("inspectionList", famService.getAllInspections());
        return "fam/employee";
    }
    
    @GetMapping("/employee_msg")
    public String goEmployeeMSG(Model model) {
        return "fam/employee_sendmsg";
    }
    
    @GetMapping("/super_db")
    public String goSuperDB(Model model) {
        model.addAttribute("employeeDBList", dbservice.getAllEmployees());
        return "fam/s_database";
    }
    
    @GetMapping("/super_msg")
    public String goSuperMSG(Model model) {
        return "fam/supe_sendmsg";
    }
    
    @GetMapping("/supervisor")
    public String goSupervisor(Model model) {
        return "fam/supervisor";
    }
    
    
    
    
    
}
