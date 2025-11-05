package se.alexjons.spring_crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.alexjons.spring_crud.model.Person;
import se.alexjons.spring_crud.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        return personService.getPersonById(id)
                .map(person -> ResponseEntity.status(200).body(person))
                .orElse(ResponseEntity.status(404).build());
    }
}
