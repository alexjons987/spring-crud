package se.alexjons.spring_crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alexjons.spring_crud.model.Person;
import se.alexjons.spring_crud.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        return personService.getPersonById(id)
                .map(person -> ResponseEntity.status(200).body(person))
                .orElse(ResponseEntity.status(404).build());
    }

    @GetMapping("/search/{searchTerm}")
    public List<Person> getPersonByOccupationSearch(@PathVariable String searchTerm) {
        return personService.findByOccupationSearch(searchTerm);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
        return personService.addNewPerson(person)
                .map(p -> ResponseEntity.status(201).body(p))
                .orElse(ResponseEntity.status(400).build());
    }
}
