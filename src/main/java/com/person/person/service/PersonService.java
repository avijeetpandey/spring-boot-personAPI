package com.person.person.service;
import com.person.person.model.Person;
import java.util.List;
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
}