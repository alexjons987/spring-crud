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
                .filter(p -> p.id() == id)
                .findFirst();
    }

    public List<Person> findByOccupationSearch(String search) {
        return people.stream()
                .filter(person -> person.occupation().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }

    public Optional<Person> addPerson(Person person) {
        int nextId = people.stream()
                .mapToInt(Person::id)
                .max()
                .orElse(0) + 1;

        Person newPerson = new Person(nextId, person.name(), person.age(), person.occupation());
        people.add(newPerson);
        return Optional.of(newPerson);
    }

    public Optional<Person> updatePerson(int id, Person newPersonDetails) {
        int index = -1;

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).id() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return Optional.empty();
        }

        Person updatedPerson = new Person(
                id,
                newPersonDetails.name(),
                newPersonDetails.age(),
                newPersonDetails.occupation()
        );
        people.set(index, updatedPerson);

        return Optional.of(updatedPerson);
    }

    public boolean deletePersonById(int id) {
        return people.removeIf(p -> p.id() == id);
    }
}
