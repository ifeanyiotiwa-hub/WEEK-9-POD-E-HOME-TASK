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

    public List<Person> getAllPersons() {
        String sql = "SELECT * FROM PERSON";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person getPersonById(int id) {
        String sql = "SELECT * FROM PERSON WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Person>(Person.class),
                new Object[] {id});
    }

    public int insertPerson(Person person) {
        String sql = "INSERT INTO PERSON (ID, Name, Nationality,Birth_date) " +
                "VALUES (?, ?, ?, ?, )";
        return jdbcTemplate.update( sql, person.getId(), person.getName(), person.getNationality(),
                new Timestamp(person.getBirthDate().getTime()));
    }

    public int updatePlayer(Person person){
        String sql = "UPDATE PLAYER " +
                "SET Name = ?, Nationality = ?, Birth_date = ?" +
                "WHERE ID = ?";

        return jdbcTemplate.update( sql,
                person.getName(),
                person.getNationality(),
                new Timestamp(person.getBirthDate().getTime()),
                person.getId());
    }

    public int deletePersonById(int id) {
        String sql="DELETE FROM PERSON WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }
}
