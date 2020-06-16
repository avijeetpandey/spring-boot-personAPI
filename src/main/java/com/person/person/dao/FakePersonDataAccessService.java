package com.person.person.dao;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import com.person.person.model.Person;

public class FakePersonDataAccessService implements PersonDao {

    //fake list
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id,Person person){
        DB.add(new Person(id,person.getName()));
        return 1;
    }
}