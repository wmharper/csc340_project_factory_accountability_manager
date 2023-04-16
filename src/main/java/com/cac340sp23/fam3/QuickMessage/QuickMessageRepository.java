package com.cac340sp23.fam3.QuickMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Billy
 */
@Repository
public interface QuickMessageRepository extends JpaRepository<QuickMessage, Long>{
    
    
    
}
