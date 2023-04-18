package com.csc340sp23.fam3.EmployeeDB;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 최연서
 */
@Entity
@Table(name = "employeeDB")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDB {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private long accScore = -1;

    public EmployeeDB(String firstName, String lastName, String phoneNum, long accScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.accScore = accScore;
    }
}
