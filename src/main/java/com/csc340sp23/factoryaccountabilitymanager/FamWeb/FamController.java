package com.csc340sp23.factoryaccountabilitymanager.FamWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/all")
    public String getIndex(Model model) {
        return "fam/index";
    }

    @GetMapping("/employee")
    public String employee(Model model) {
        return "fam/employee";
    }

    @GetMapping("/supervisor")
    public String supervisor(Model model) {
        return "fam/supervisor";
    }
    
    @GetMapping("/admin")
    public String admin(Model model) {
        return "fam/admin";
    }
    
    @GetMapping("/inspection")
    public String inspection(Model model) {
        return "fam/inspection";
    }
    
    @GetMapping("/dataSuper")
    public String getDatabaseSuper(Model model) {
        return "fam/dataSuper";
    }
    
    @GetMapping("/dataAdmin")
    public String getDataAdmin(Model model) {
        return "fam/dataAdmin";
    }
    
}
