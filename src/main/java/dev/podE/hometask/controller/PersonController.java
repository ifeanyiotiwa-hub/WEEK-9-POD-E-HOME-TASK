package dev.podE.hometask.controller;


import dev.podE.hometask.model.Person;
import dev.podE.hometask.service.PersonService;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("/person")
    public String savePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return "Person saved";
    }

    @DeleteMapping(path = "person/{id}")
    public String deletePerson(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "person with id "+id+ " deleted";

    }
    @PutMapping(path = "person/{id}")
    public String updatePerson(@PathVariable("id")int id, @RequestBody Person person){
        personService.updatePerson(person,id);
        return "person with the id of "+id+" updated";
    }
    @GetMapping(path = "person/{id}")
    public  String getPersonById(@PathVariable("id")int id){
        Person person = new Person();
        person.setId(id);
        return person+" with id "+id+ " gotten from the DB";
    }

    public List<Person> getAllPersons(){
        List<Person> personList = new ArrayList<>();
        return  personList;
    }
}
