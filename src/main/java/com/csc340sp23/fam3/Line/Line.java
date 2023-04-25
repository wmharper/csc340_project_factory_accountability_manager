package com.csc340sp23.fam3.Line;

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
 * @author Darian
 */
@Entity
@Table(name = "line")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private double lineSeed;
    private long employee;
    private long supervisor;
    
    public Line(double seed, long watcher) {
        this.lineSeed = seed;
        this.supervisor = watcher;
    }
}
