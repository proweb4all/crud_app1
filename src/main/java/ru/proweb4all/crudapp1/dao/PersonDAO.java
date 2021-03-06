package ru.proweb4all.crudapp1.dao;

import org.springframework.stereotype.Component;
import ru.proweb4all.crudapp1.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Yury"));
        people.add(new Person(++PEOPLE_COUNT, "Vasia"));
        people.add(new Person(++PEOPLE_COUNT, "Anna"));
        people.add(new Person(++PEOPLE_COUNT, "Alex"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
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
    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }
    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
