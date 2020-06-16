package com.person.person.service;
import com.person.person.model.Person;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.person.person.dao.PersonDao;

@Service
public class PersonService {

    private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao=personDao;
    }

    public int addPerson(Person person){
            return personDao.insertPerson(person);
    }

    public List<Person> getPersons(){
        return personDao.getPersons();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id,Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }

}