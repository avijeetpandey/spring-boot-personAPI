package com.person.person.api;
import com.person.person.model.Person;
import com.person.person.service.PersonService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    
    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping(path="{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
 
    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") UUID id,  @RequestBody Person person){
        personService.updatePerson(id,person);
    }

}