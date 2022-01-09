package dev.podE.hometask.service;

import dev.podE.hometask.model.Person;

public interface PersonService {

    // Emeka Chuwudozie
    void savePerson(Person person);

    void deletePerson(int id);

    void updatePerson(Person person, int id);
}