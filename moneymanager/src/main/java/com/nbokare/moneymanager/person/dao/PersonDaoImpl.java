package com.nbokare.moneymanager.person.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nbokare.moneymanager.person.controller.PersonController;
import com.nbokare.moneymanager.person.model.Person;

@Repository
public class PersonDaoImpl {
	public static final Logger logger = Logger.getLogger(PersonController.class);

    @Autowired
    SessionFactory sessionFactory;

    // @Autowired
    // LocalSessionFactoryBean sessionFactoryBean;

    // @PersistenceContext
    // EntityManager entityManager;

    @PostConstruct
    public void init() {
		logger.debug("**************************** initialized DAO *************************************");
    }

    @Transactional
    public List<Person> getPersons() {

        // List persons = sessionFactoryBean.getObject().getCurrentSession()
        // .createQuery("from TestPerson").list();

        List persons = sessionFactory.getCurrentSession()
                .createQuery("from Person").list();

        List<Person> list = new ArrayList<Person>();
        for (Object object : persons) {
            if (object instanceof Person) {
                Person person = (Person) object;
                list.add(person);
                System.out.println("**************** Person - "
                        + person.toString());
            }
        }

        return list;
        // return null;
    }

    @Transactional
    public Person getPerson(int id) {

        // List persons = sessionFactoryBean.getObject().getCurrentSession()
        // .createQuery("from TestPerson").list();

        return (Person) sessionFactory.getCurrentSession().get(
                Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Transactional
    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Transactional
    public int getMaxId() {
        return (Integer) sessionFactory.getCurrentSession()
                .createQuery("select max(id) from Person").list().get(0);
    }
}
