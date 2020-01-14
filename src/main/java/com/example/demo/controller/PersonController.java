package com.example.demo.controller;

import com.example.demo.PeopleNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.utils.CsvUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("${demo.api.endpoints.list}")
    public ResponseEntity<Page<Person>> list() {
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @GetMapping("${demo.api.endpoints.get-by-id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) throws PeopleNotFoundException {
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }

    @PostMapping("${demo.api.endpoints.save}")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
    }

    @PostMapping(value = "${demo.api.endpoints.upload}", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadSimple(@RequestBody MultipartFile body) throws IOException {
        personService.saveAll(CsvUtils.read(Person.class, body.getInputStream()));
        return ResponseEntity.ok("File uploaded");
    }

    @PutMapping("${demo.api.endpoints.update-put}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.update(person, id), HttpStatus.OK);
    }

    @DeleteMapping("${demo.api.endpoints.update-put}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}