package dev.podE.hometask.serviceimpl;

import dev.podE.hometask.model.Person;
import dev.podE.hometask.repository.PersonRepository;
import dev.podE.hometask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {

    // By Emeka Chukwudozie

    @Autowired
    PersonRepository repository;

    /**
     * This method saves a person to the Database
     * making use of the repository method
     * @param person
     */
    @Override
    public void savePerson(Person person) {
        repository.savePerson(person);
        System.out.println(person.toString()+" Saved Successfully");
    }
}
