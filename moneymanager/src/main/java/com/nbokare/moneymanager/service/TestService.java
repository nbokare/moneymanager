package com.nbokare.moneymanager.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbokare.moneymanager.dao.TestPersonDaoImpl;
import com.nbokare.moneymanager.model.TestPerson;

@Service
public class TestService {
    @Autowired
    TestPersonDaoImpl dao;

    @PostConstruct
    public void init() {
        System.out
                .println("**************************** service initialized *************************************");
    }

    public TestPerson create(TestPerson person) {
        System.out.println("Creating person : " + person);
        int id = person.getId();
        dao.save(person);

        return dao.getPerson(id);
        // return dao.getPerson(id);
    }

    public TestPerson update(TestPerson person) {
        if (person == null) {
            System.out.println("null person passed to update");
            return null;
        }

        int id = person.getId();
        System.out.println("Updating person : " + id);
        TestPerson existingPerson = dao.getPerson(id);

        if (existingPerson == null) {
            System.out.println("Person with ID " + id + " does not exist.");
            return null;
        }
        dao.update(person);

        return dao.getPerson(id);
        // return dao.getPerson(id);
    }

    public List<TestPerson> getPersons() {
        System.out
                .println("******************** In service - Fetching persons.");
        return dao.getPersons();
        // return null;
    }

    public TestPerson getPerson(int id) {
        TestPerson person = dao.getPerson(id);

        if (person == null) {
            System.out.println("Invalid ID " + id);
            return null;
        } else {
            return person;
        }
    }
}
