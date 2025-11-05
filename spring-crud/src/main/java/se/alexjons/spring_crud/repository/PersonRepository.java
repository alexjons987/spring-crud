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
    }

    public Optional<Person> findById(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }
}
