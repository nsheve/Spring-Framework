package ru.sheve.springcours.dao;

import org.springframework.stereotype.Component;
import ru.sheve.springcours.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Nikita"));
        people.add(new Person(++PEOPLE_COUNT, "Dima"));
        people.add(new Person(++PEOPLE_COUNT, "Sveta"));
        people.add(new Person(++PEOPLE_COUNT, "Anna"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
