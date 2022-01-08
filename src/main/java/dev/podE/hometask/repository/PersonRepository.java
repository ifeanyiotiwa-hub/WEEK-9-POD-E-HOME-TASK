package dev.podE.hometask.repository;

import dev.podE.hometask.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonRepository {

    JdbcTemplate jdbcTemplate;


    public int savePerson(Person person) {
        String sql = "INSERT INTO PERSON (ID, Name, Nationality,Birth_date) " +
                "VALUES (?, ?, ?, ?, )";
        return jdbcTemplate.update( sql, person.getId(), person.getName(), person.getNationality(),
                new Timestamp(person.getBirthDate().getTime()));
    }

}
