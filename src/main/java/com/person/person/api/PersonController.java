package com.person.person.api;
import com.person.person.model.Person;
import com.person.person.service.PersonService;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService=personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
    
}