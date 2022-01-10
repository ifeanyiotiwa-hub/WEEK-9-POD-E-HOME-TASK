package dev.podE.hometask.controller;


import dev.podE.hometask.response.ResponseData;
import dev.podE.hometask.model.Subject;
import dev.podE.hometask.model.Person;
import dev.podE.hometask.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class PersonController {

    private final PersonService personService;
    private WebClient.Builder builder;


    @Autowired
    public PersonController(PersonService personService,WebClient.Builder builder) {
        this.personService = personService;
        this.builder=builder;
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
    @GetMapping( "/person/{id}/{subjects}")
    public ResponseEntity<ResponseData> getPersonById(@PathVariable("id")int id, @PathVariable("subjects") String subjects){
        Person person = personService.getPersonById(id);
         ResponseData responseData = new ResponseData();

        Subject subject = builder.build()
                .get()
                .uri("https://openlibrary.org/subjects/" + subjects + ".json")
                .retrieve()
                .bodyToMono(Subject.class)
                .block();

        responseData.setSubject(subject);
        responseData.setPerson(person);
        person.setKey(subject.getKey());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


    @GetMapping("/person")
    public List<Person> getAllPersons(){
        return personService.getPersons();
    }
}
