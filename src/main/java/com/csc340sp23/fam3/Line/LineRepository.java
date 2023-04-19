package com.csc340sp23.fam3.Line;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Darian
 */
@Repository
public class LineRepository {

    @Autowired
    NamedParameterJdbcTemplate structure;

    List<Line> findAll() {

        String query = "select line_seed, employee, supervisor from line";
        return structure.query(query,
                (result, rowNum)
                -> new Line(
                        result.getDouble("line_seed"),
                        result.getLong("supervisor")
                ));
    }

    public List<Line> getYourLines(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from line where supervisor=:id";
        List<Line> lines = structure.query(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Line.class));
        // Sort by unread, cross-referenced by time
        return lines;
    }
    
    public Line lineById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from line where id=:id ";
        return structure.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Line.class));
    }

    public int newLine(Line line) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", line.getId());
        paramMap.put("line_seed", line.getLineSeed());
        paramMap.put("supervisor", line.getSupervisor());
        String query = "insert into line(line_seed, supervisor) VALUES(:line_seed, :supervisor)";
        return structure.update(query, paramMap);
    }
    
    public void reseedLine(Line line) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", line.getId());
        paramMap.put("line_seed", line.getLineSeed());
        paramMap.put("supervisor", line.getSupervisor());
        String query = "update line set line_seed=:line_seed, supervisor=:supervisor where id=:id";
        structure.update(query, paramMap);
    }
}
