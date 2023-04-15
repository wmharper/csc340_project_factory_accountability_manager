package com.csc340sp23.fam3.EmployeeDB;

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
 * @author 최연서
 */
@Repository
public class EmployeeDBRepository {
    
    @Autowired
    NamedParameterJdbcTemplate template;

    List<EmployeeDB> findAll() {

        String query = "select id, first_name, last_name, phone_num, acc_score from employeeDB";
        return template.query(query,
                (result, rowNum)
                -> new EmployeeDB(result.getLong("id"),
                        result.getString("first_name"), result.getString(
                        "last_name"), result.getString("phone_num"),
                        result.getLong("acc_score")));
    }

    public EmployeeDB getEmployeeById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from employeeDB where id=:id ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(EmployeeDB.class));
    }

    public int saveEmployee(EmployeeDB employee) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", employee.getFirstName());
        paramMap.put("last_name", employee.getLastName());
        paramMap.put("phone_num", employee.getPhoneNum());
        paramMap.put("acc_score", employee.getAccScore());
        String query = "INSERT INTO employeeDB(first_name, last_name, phone_num, acc_score) VALUES(:first_name, :last_name, :phone_num, :acc_score)";
        return template.update(query, paramMap);
    }

    void deleteEmployeeById(long id) {

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from employeeDB where id=:id";
        template.update(query, namedParameters);
    }

    void updateEmployee(EmployeeDB employee) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", employee.getId());
        paramMap.put("first_name", employee.getFirstName());
        paramMap.put("last_name", employee.getLastName());
        paramMap.put("phone_num", employee.getPhoneNum());
        paramMap.put("acc_score", employee.getAccScore());
        String query = "update employeeDB set first_name=:first_name, last_name=:last_name, phone_num=:phone_num, acc_score=:acc_score where id=:id ";
        template.update(query, paramMap);
    }
}
