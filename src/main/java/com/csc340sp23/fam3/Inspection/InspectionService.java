/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.fam3.Inspection;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Billy
 */
@Service
public class InspectionService {

    @Autowired
    private InspectionRepository repo;
    
    public List<Inspection> getAllInspections() {
        return repo.findAll();
    }

    void saveInspection(Inspection inspection) {
        repo.save(inspection);
    }

}
