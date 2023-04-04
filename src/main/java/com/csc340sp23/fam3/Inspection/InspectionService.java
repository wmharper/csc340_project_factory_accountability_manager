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

    void passInspection(Long id) {
        Inspection inspection = repo.findById(id).orElse(null);
        if (inspection != null && inspection.getForm() >= 7 && inspection.getQuality() >= 7) {
            inspection.setResult(2);
            repo.save(inspection);
        } else {
            inspection.setResult(0);
            repo.save(inspection);
        }
    }
    
    void failInspection(Long id) {
        Inspection inspection = repo.findById(id).orElse(null);
        if (inspection != null && (inspection.getForm() <= 7 || inspection.getQuality() <= 7) ) {
            inspection.setResult(2);
            repo.save(inspection);
        } else {
            inspection.setResult(1);
            repo.save(inspection);
        }
    }

}
