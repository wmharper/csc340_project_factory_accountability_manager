package com.csc340sp23.fam3.FamWeb;

import com.csc340sp23.fam3.EmployeeDB.EmployeeDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
        model.addAttribute("qmList", famService.getAllQuickMessages());
        return "fam/home";
    }
    
    @GetMapping("/admin_msg")
    public String goAdminMSG(Model model) {
        model.addAttribute("qmList", famService.getAllQuickMessages());
        return "fam/a_sendmsg";
    }
    
    @GetMapping({"/admin", "/administrator"})
    public String goAdmin(Model model) {
        model.addAttribute("qmList", famService.getAllQuickMessages());
        return "fam/admin";
    }
    
    @GetMapping("/employee")
    public String goEmployee(Model model) {
        model.addAttribute("qmList", famService.getAllQuickMessages());
        
        model.addAttribute("inspectionList", famService.getAllInspections());
        return "fam/employee";
    }
    
    @GetMapping("/employee_msg")
    public String goEmployeeMSG(Model model) {
        
        model.addAttribute("qmList", famService.getAllQuickMessages());
        return "fam/employee_sendmsg";
    }
    
    @GetMapping("/super_db")
    public String goSuperDB(Model model) {
        model.addAttribute("employeeDBList", dbservice.getAllEmployees());
        return "fam/s_database";
    }
    
    @GetMapping("/super_msg")
    public String goSuperMSG(Model model) {
        model.addAttribute("qmList", famService.getAllQuickMessages());
        return "fam/supe_sendmsg";
    }
    
    @GetMapping("/supervisor")
    public String goSupervisor(Model model) {
        model.addAttribute("qmList", famService.getAllQuickMessages());
        return "fam/supervisor";
    }
    
    
    
    
    
}
