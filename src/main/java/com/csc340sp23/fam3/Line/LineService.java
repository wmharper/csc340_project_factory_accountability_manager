package com.csc340sp23.fam3.Line;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darian
 */
@Service
public class LineService {

    @Autowired
    LineRepository repo;

    public List<Line> getYourLines(long id) {
        return repo.getYourLines(id);
    }

    public Line getLine(long id) {
        return repo.lineById(id);
    }
    
    public void makeNewLine(Line line) {
        repo.newLine(line);
    }
    
    public void reseed(long id) {
        Line line = repo.lineById(id);
        Random random = new Random();
        double newSeed = random.nextDouble(5, 10);
        line.setLineSeed(newSeed);
        repo.reseedLine(line);
    }
}
