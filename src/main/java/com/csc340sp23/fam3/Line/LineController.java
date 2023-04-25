package com.csc340sp23.fam3.Line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Darian
 */
@Controller
@RequestMapping("/line")
public class LineController {

    @Autowired
    LineService lineService;
    
    @GetMapping("/yours/id={id}")
    public String yourLines(@PathVariable long id, Model model) {
        model.addAttribute("lines", lineService.getYourLines(id));
        return "redirect:/fam/supervisor";
    }
    
    @PostMapping("/create")
    public String newLine(Line line) {
        lineService.makeNewLine(line);
        return "redirect:/fam/supervisor";
    }
    
    @PostMapping("/reseed")
    public String reseedLine(@RequestParam("id") Long id, Model model) {
        lineService.reseed(id);
        return "redirect:/fam/supervisor";
    }
}
