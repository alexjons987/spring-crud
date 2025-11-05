package se.alexjons.spring_crud.repository;

import org.springframework.stereotype.Repository;
import se.alexjons.spring_crud.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private List<Person> people = new ArrayList<>();

    public PersonRepository() {
        people.add(new Person(1, "Alex", 25, "System Developer"));
        people.add(new Person(2, "Bob", 30, "SCRUM Master"));
        people.add(new Person(3, "Carl", 34, "Project Owner"));
        people.add(new Person(4, "Daniel", 34, "Frontend Developer"));
    }

    public Optional<Person> findById(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    public List<Person> findByOccupationSearch(String search) {
        return people.stream()
                .filter(person -> person.getOccupation().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }

    public Person addPerson(Person person) {
        int nextId = people.stream()
                .mapToInt(Person::getId)
                .max()
                .orElse(0) + 1;
        person.setId(nextId);
        people.add(person);
        return person;
    }
}
