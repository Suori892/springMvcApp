package com.example.mvc.dao;

import com.example.mvc.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.print.attribute.IntegerSyntax;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> show(String email) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?",
                        new Object[]{email}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

   public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
   }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, position, email, address, admin) VALUES (?, ?, ?, ?, false);",
                person.getName(), person.getPosition(), person.getEmail(), person.getAddress());
    }

   public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, position=?, email=?, address=?, admin=false WHERE id=?",
                updatedPerson.getName(), updatedPerson.getPosition(), updatedPerson.getEmail(),
                updatedPerson.getAddress(),
                id);
   }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    // set/delete admin
    public void setAdmin(int id) {
        jdbcTemplate.update("UPDATE  Person SET admin=true WHERE id=?", id);
    }

    public void deleteAdmin(int id) {
        jdbcTemplate.update("UPDATE  Person SET admin=false WHERE id=?", id);
    }
}
