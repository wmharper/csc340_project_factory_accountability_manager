package com.csc340sp23.fam3.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Darian
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService msgService;
    
    @PostMapping("/ce")
    public String sendEmployeeMessage(Message message) {
        msgService.send(message);
        return "redirect:/fam/employee";
    }
    
    @PostMapping("/cs")
    public String sendSupervisorMessage(Message message) {
        msgService.send(message);
        return "redirect:/fam/supervisor";
    }
    
    @PostMapping("/ca")
    public String sendAdminMessage(Message message) {
        msgService.send(message);
        return "redirect:/fam/admin";
    }
    
    @PostMapping("/re/id={id}")
    public String readEmployeeMessage(@PathVariable long id, Model model) {
        //msgService.read(message);
        return "redirect:/fam/employee";
    }
    
    @PostMapping("/rs/id={id}")
    public String readSupervisorMessage(@PathVariable long id, Model model) {
        model.addAttribute("message", msgService.getMessage(id));
        return "redirect:/fam/supervisor";
    }
    
    @PostMapping("/ra/id={id}")
    public String readAdminMessage(@PathVariable long id, Model model) {
        //msgService.read(message);
        return "redirect:/fam/admin";
    }
}
