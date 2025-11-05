package se.alexjons.spring_crud.service;

import org.springframework.stereotype.Service;
import se.alexjons.spring_crud.model.Person;
import se.alexjons.spring_crud.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    public List<Person> findByOccupationSearch(String search) {
        return personRepository.findByOccupationSearch(search);
    }

    public Optional<Person> addNewPerson(Person person) {
        return personRepository.addPerson(person);
    }
}
