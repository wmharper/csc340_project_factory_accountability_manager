package com.csc340sp23.fam3.Inspection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Billy
 */

@Repository
public interface InspectionRepository extends JpaRepository<Inspection, Long>{
    
}
