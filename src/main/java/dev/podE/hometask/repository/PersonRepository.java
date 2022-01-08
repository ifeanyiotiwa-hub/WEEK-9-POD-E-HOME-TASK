package dev.podE.hometask.repository;

import dev.podE.hometask.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class PersonRepository {

    JdbcTemplate jdbcTemplate;

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int savePerson(Person person) {
        String sql = "INSERT INTO PERSON (ID, First_name, Last_name, Email, Password, Nationality, Birth_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update( sql, person.getId(), person.getFirstName(), person.getLastName(), person.getEmail(), person.getPassword(), person.getNationality(),
                new Timestamp(person.getBirthDate().getTime()));
    }

}

