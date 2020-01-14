package com.example.demo.service;

import com.example.demo.PeopleNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
    Pageable secondPageWithFiveElements = PageRequest.of(1, 5);

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<Person> getPersons() {
        return personRepository.findAll(firstPageWithTwoElements);
    }

    public Person getById(Long id) throws PeopleNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException("1"));
    }

    public Person save(Person person) {
        return personRepository.saveAndFlush(person);
    }

    public List<Person> saveAll(List<Person> persons) {
        return personRepository.saveAll(persons);
    }

    public Person update(Person person, Long id) {
        person.setId(id);
        return personRepository.saveAndFlush(person);
    }

    public void delete(Long id) {
        personRepository.delete(new Person(id));
    }
}