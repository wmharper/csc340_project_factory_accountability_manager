package com.csc340sp23.fam3.FamWeb;

import com.cac340sp23.fam3.QuickMessage.QuickMessage;
import com.cac340sp23.fam3.QuickMessage.QuickMessageRepository;
import com.csc340sp23.fam3.Inspection.Inspection;
import com.csc340sp23.fam3.Inspection.InspectionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Billy
 */
@Service
public class FamService {
    
    @Autowired
    private InspectionRepository repo;
    private QuickMessageRepository repo1;
    
        public List<Inspection> getAllInspections() {
        return repo.findAll();
    }

    public List<QuickMessage> getAllQuickMessages() {
        return repo1.findAll();
    }
    
    
}
