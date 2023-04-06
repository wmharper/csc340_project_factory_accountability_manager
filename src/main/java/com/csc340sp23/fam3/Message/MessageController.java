package com.csc340sp23.fam3.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/create")
    public String sendMessage(Message message) {
        msgService.send(message);
        return "redirect:/fam/supervisor";
    }
    
    @PostMapping("/read")
    public String readMessage() {
        return "redirect:/fam/supervisor";
    }
}
