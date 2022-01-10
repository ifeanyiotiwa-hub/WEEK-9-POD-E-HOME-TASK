package dev.podE.hometask.repository;

import dev.podE.hometask.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class PersonRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int savePerson(Person person) {
        String sql = "INSERT INTO person (first_name, last_name, email, password, nationality, birth_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update( sql, person.getFirstName(), person.getLastName(), person.getEmail(), person.getPassword(), person.getNationality(),
                person.getBirthDate());
    }

    public void deletePerson(int id){
        String sql = "DELETE  FROM person WHERE id=?";
         jdbcTemplate.update( sql,id);
    }

    public void updatePerson(Person person){
        String sql = "UPDATE person SET first_name=?, last_name=?, " +
                "email=?, password = ?, nationality=?, birth_date=? WHERE id=?";
        Object [] params = {person.getFirstName(), person.getLastName(), person.getEmail(), person.getPassword(), person.getNationality(),
                person.getBirthDate(),person.getId()};
        jdbcTemplate.update(sql,params);
    }

    public Person getPersonById(int id){
        String sql = "SELECT * FROM person WHERE id=?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Person.class),id);
    }

    public List<Person> getAllPersons() {

        return jdbcTemplate.query(
                "SELECT * FROM person",
                (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"), "*******",
                        rs.getString("nationality"), rs.getDate("birth_date")));
    }

}

