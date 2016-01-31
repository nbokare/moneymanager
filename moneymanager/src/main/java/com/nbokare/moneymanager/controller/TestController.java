package com.nbokare.moneymanager.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nbokare.moneymanager.model.TestPerson;
import com.nbokare.moneymanager.service.TestService;

@Controller
@RequestMapping("/testing")
public class TestController {
    @Autowired
    TestService testService;

    @PostConstruct
    public void init() {
        System.out.println("******************** initing **************");

        System.out.println("******************** Classpath - "
                + System.getProperty("java.class.path"));

        System.out.println("******************** Properties - "
                + System.getProperties());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/persons/{id}")
    @ResponseBody
    public TestPerson get(@PathVariable int id) {
        System.out.println("******************** in get **************");
        return testService.getPerson(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/persons")
    @ResponseBody
    public List<TestPerson> list() {
        System.out.println("******************** in list **************");
        return testService.getPersons();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/persons")
    @ResponseBody
    public TestPerson create(@RequestBody TestPerson person) {
        System.out.println("******************** in create **************");
        return testService.create(person);
    }

    // @RequestMapping(method = RequestMethod.GET, value = "/getstring")
    // @ResponseBody
    // public String testing() {
    // System.out.println("******************** in testing **************");
    // return "{name:Nikhil,id:1}";
    // }
}
