package dev.podE.hometask.controller;


import dev.podE.hometask.model.Person;
import dev.podE.hometask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
