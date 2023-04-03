package com.csc340sp23.fam3.Inspection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Billy
 */

@Controller
@RequestMapping("/inspection")
public class InspectionController {
    @Autowired
    InspectionService inspectionService;
    
    @GetMapping("/create")
    public String getInspections(Model model) {
        model.addAttribute("inspectionList", inspectionService.getAllInspections());
        return "redirect:/fam/employee";
    }
    
    @PostMapping("/create")
    public String createInspection(Inspection inspection) {
        inspectionService.saveInspection(inspection);
        return "redirect:/fam/employee";
    }
}
