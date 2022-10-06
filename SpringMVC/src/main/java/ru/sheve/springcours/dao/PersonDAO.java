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

        people.add(new Person(++PEOPLE_COUNT, "Nikita", 21, "nsheve@inbox.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Dima", 22, "dima@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Sveta", 28, "28sveta@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Anna", 31, "an2006@inbox.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person person = show(id);
        person.setName(updatePerson.getName());
        person.setAge(updatePerson.getAge());
        person.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.remove(show(id));
    }
}
