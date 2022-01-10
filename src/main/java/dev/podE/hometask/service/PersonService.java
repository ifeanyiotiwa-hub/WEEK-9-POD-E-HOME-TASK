package dev.podE.hometask.service;

import dev.podE.hometask.model.Person;

import java.util.List;

public interface PersonService {

    // Emeka Chuwudozie
    void savePerson(Person person);

    void deletePerson(int id);

    void updatePerson(Person person, int id);

    Person getPersonById( int id);

    List<Person> getPersons();
}