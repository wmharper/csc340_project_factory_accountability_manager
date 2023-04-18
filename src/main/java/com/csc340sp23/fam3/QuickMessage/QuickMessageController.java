/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.fam3.QuickMessage;

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
@RequestMapping("/qm")
public class QuickMessageController {

    @Autowired
    QuickMessageService qmService;

//    @GetMapping("/all")
//    public String getQuickMessages(Model model) {
//        return "redirect:/fam/employee_msg";
//    }

//    @PostMapping("/createmessage")
//    public String createQuickMessage(QuickMessage qm) {
//        qmService.saveQM(qm);
//        return "redirect:/fam/employee_msg";
//    }

    @PostMapping("/alert_supervisor")
    public String createSupervisorAlert(QuickMessage qm){
        qmService.createSupervisorAlert(qm);
        return "redirect:/fam/employee_msg";
    }
    
    @PostMapping("/create_catfact")
    public String createCatFactMessage(QuickMessage qm){
        qmService.createCatFactQuickMessage(qm);
        return "redirect:/fam/employee_msg";
    }
    
    @PostMapping("/create_meeting_request")
    public String createMeetingRequest(QuickMessage qm){
        qmService.createMeetingRequest(qm);
        return "redirect:/fam/super_msg";
    }
    
    @PostMapping("/create_kudos")
    public String createKudos(QuickMessage qm){
        qmService.createKudos(qm);
        return "redirect:/fam/admin_msg";
    }
    
    @PostMapping("/rec_meeting")
    public String recommendMeeting(QuickMessage qm){
        qmService.recommendMeeting(qm);
        return "redirect:/fam/admin_msg";
    }
    
    @PostMapping("/recommend_firing")
    public String recommendFiring(QuickMessage qm){
        qmService.recommendFiring(qm);
        return "redirect:/fam/super_msg";
    }
}
