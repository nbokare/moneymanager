package com.nbokare.moneymanager.person.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbokare.moneymanager.person.dao.PersonDaoImpl;
import com.nbokare.moneymanager.person.model.Person;

@Service
public class PersonServiceImpl {
    @Autowired
    PersonDaoImpl dao;

    @PostConstruct
    public void init() {
        System.out
                .println("**************************** service initialized *************************************");
    }

    public Person create(Person person) {
        System.out.println("Creating person : " + person);
        int id = dao.getMaxId() + 1;
        person.setId(id);
        dao.save(person);

        return dao.getPerson(id);
        // return dao.getPerson(id);
    }

    public Person update(Person person) {
        if (person == null) {
            System.out.println("null person passed to update");
            return null;
        }

        int id = person.getId();
        System.out.println("Updating person : " + id);
        Person existingPerson = dao.getPerson(id);

        if (existingPerson == null) {
            System.out.println("Person with ID " + id + " does not exist.");
            return null;
        }
        dao.update(person);

        return dao.getPerson(id);
        // return dao.getPerson(id);
    }

    public List<Person> getPersons() {
        System.out
                .println("******************** In service - Fetching persons.");
        return dao.getPersons();
        // return null;
    }

    public Person getPerson(int id) {
        Person person = dao.getPerson(id);

        if (person == null) {
            System.out.println("Invalid ID " + id);
            return null;
        } else {
            return person;
        }
    }

    public long getMaxId() {
        return dao.getMaxId();
    }
}
