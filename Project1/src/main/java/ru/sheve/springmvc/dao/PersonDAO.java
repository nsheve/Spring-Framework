package ru.sheve.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sheve.springmvc.model.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Метод вывода всех пользователей библиотеки
    public List<Person> show() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    //Метод вывода по индексу пользователя
    public Person index(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=id",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    //Метод добавления пользователя
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person (name, yearOfBirth) VALUES (?, ?)",
                person.getName(), person.getYearOfBirth());
    }

    //Метод обновления данных о пользователе
    public void update(Person updatePerson, int id) {
        jdbcTemplate.update("UPDATE person SET name=?, yearOfBirth=? WHERE person_id=?",
                updatePerson.getName(), updatePerson.getYearOfBirth());
    }

    //Метод удаления пользователя
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE person_id=?", id);
    }
}
