package se.alexjons.spring_crud.controller;

import org.apache.coyote.Response;
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
    public List<ResponseEntity<Person>> getPersonByOccupationSearch(@PathVariable String searchTerm) {
        return personService.findByOccupationSearch(searchTerm).stream()
                .map(p -> ResponseEntity.status(200).body(p))
                .toList();
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addNewPerson(@RequestBody Person person) {
        return personService.addNewPerson(person)
                .map(p -> ResponseEntity.status(201).body(p))
                .orElse(ResponseEntity.status(400).build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return personService.updatePerson(id, person)
                .map(p -> ResponseEntity.status(200).body(p))
                .orElse(ResponseEntity.status(400).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id) {
        boolean removed = personService.deletePersonById(id);
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/multisearch")
    public List<ResponseEntity<Person>> getPeopleBySearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String occupation
    ) {
        return personService.getPeopleBySearch(name, occupation).stream()
                .map(p -> ResponseEntity.status(200).body(p))
                .toList();
    }
}
