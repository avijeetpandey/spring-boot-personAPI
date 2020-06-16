package com.person.person.service;
import com.person.person.model.Person;
import com.person.person.dao.PersonDao;

public class PersonService {

    private final PersonDao personDao;
    public PersonService(PersonDao personDao){
        this.personDao=personDao;
    }

    public int addPerson(Person person){
            return personDao.insertPerson(person);
    }
}