package com.person.person.dao;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.person.person.model.Person;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    // fake list
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getPersons() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person->person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isEmpty())
               return 0;
        else DB.remove(personMayBe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person Uperson) {
        return selectPersonById(id).map(p->{
            int index=DB.indexOf(p);
            if(index >= 0){
                DB.set(index,new Person(id,Uperson.getName()));
                return 1;
            }else return 0;
        }).orElse(0);
    }
}