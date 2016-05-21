package com.nbokare.moneymanager.person.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nbokare.moneymanager.person.model.Person;
import com.nbokare.moneymanager.person.service.PersonServiceImpl;

@Controller
@RequestMapping("/testing")
public class PersonController {
	public static final Logger logger = Logger.getLogger(PersonController.class);

	@Autowired
	PersonServiceImpl testService;

	@PostConstruct
	public void init() {
		logger.debug("********************* initilizing controller *********************");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/persons/{id}")
	@ResponseBody
	public Person get(@PathVariable int id) {
		logger.debug("******************** in get **************");
		return testService.getPerson(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/persons")
	@ResponseBody
	public List<Person> list() {
		logger.debug("******************** in list **************");
		return testService.getPersons();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/persons")
	@ResponseBody
	public Person create(@RequestBody Person person) {
		logger.debug("******************** in create **************");
		return testService.create(person);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/persons/{id}")
	@ResponseBody
	public Person update(@RequestBody Person person) {
		logger.debug("******************** in update **************");
		return testService.update(person);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/personsmaxid")
	@ResponseBody
	public long getMaxId() {
		logger.debug("******************** in update **************");
		return testService.getMaxId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getstring")
	@ResponseBody
	public String testing() {
		logger.debug("******************** in testing **************");
		return "{name:Nikhil,id:1}";
	}
}
