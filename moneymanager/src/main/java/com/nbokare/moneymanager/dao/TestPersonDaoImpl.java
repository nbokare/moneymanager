package com.nbokare.moneymanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nbokare.moneymanager.model.TestPerson;

@Repository
public class TestPersonDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    // @Autowired
    // LocalSessionFactoryBean sessionFactoryBean;

    // @PersistenceContext
    // EntityManager entityManager;

    @PostConstruct
    public void init() {
        System.out
                .println("**************************** initialized DAO *************************************");
    }

    @Transactional
    public List<TestPerson> getPersons() {

        // List persons = sessionFactoryBean.getObject().getCurrentSession()
        // .createQuery("from TestPerson").list();

        List persons = sessionFactory.getCurrentSession()
                .createQuery("from TestPerson").list();

        List<TestPerson> list = new ArrayList<TestPerson>();
        for (Object object : persons) {
            if (object instanceof TestPerson) {
                TestPerson person = (TestPerson) object;
                list.add(person);
                System.out.println("**************** Person - "
                        + person.toString());
            }
        }

        return list;
        // return null;
    }

    @Transactional
    public TestPerson getPerson(int id) {

        // List persons = sessionFactoryBean.getObject().getCurrentSession()
        // .createQuery("from TestPerson").list();

        return (TestPerson) sessionFactory.getCurrentSession().get(
                TestPerson.class, id);
    }

    @Transactional
    public void save(TestPerson person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Transactional
    public void update(TestPerson person) {
        sessionFactory.getCurrentSession().update(person);
    }
}
