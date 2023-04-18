package com.csc340sp23.fam3.EmployeeDB;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 최연서
 */
@Service
public class EmployeeDBService {
    
    @Autowired
    EmployeeDBRepository repo;

    public List<EmployeeDB> getAllEmployees() {
        return repo.findAll();
    }

    Object getEmployee(long id) {
        return repo.getEmployeeById(id);
    }

    void deleteEmployee(long id) {
        repo.deleteEmployeeById(id);
    }

    void saveEmployee(EmployeeDB employee) {
        repo.saveEmployee(employee);
    }

    void updateEmployee(EmployeeDB employee) {
        repo.updateEmployee(employee);
    }
}
