package com.person.person.dao;
import com.person.person.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id , Person person);
    default int insertPerson(Person person){
        UUID id=UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getPersons();

}