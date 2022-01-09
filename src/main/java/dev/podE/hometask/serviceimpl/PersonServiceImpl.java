package dev.podE.hometask.serviceimpl;

import dev.podE.hometask.model.Person;
import dev.podE.hometask.repository.PersonRepository;
import dev.podE.hometask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    @Override
    public void deletePerson(int id) {
        repository.deletePerson(id);
    }

    @Override
    public void updatePerson(Person person,int id) {
        person.setId(id);
        repository.updatePerson(person);
        System.out.println(person.toString()+"Updated successfully");
    }
}
