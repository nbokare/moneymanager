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
