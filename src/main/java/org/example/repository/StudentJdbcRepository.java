package org.example.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countOfStudent() {
        return jdbcTemplate.queryForObject("select count(1) from student", Integer.class);
    }

    public List<String> getStudentNameList() {
        return jdbcTemplate.queryForList("select name from student", String.class);
    }

    public int insertStudent(String name, int age) {
        return jdbcTemplate.update("insert into student(name, age) values(?, ?)", name, age);
    }
}
