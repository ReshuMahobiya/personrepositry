package com.person.registry;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepositry personRepositry;
	
	@Override
	public List<Person> getAllPersons() {
		
		return personRepositry.findAll();
	}

	@Override
	public Person savePerson(Person person) {
		
		return personRepositry.save(person);
	}

	@Override
	public Map<String,String> getOldestChild() {
		
		List<Person> persons = personRepositry.findAll();
		Map<String,String> pair = new HashMap<String, String>();
		Long age = (long) persons.get(0).getChildAge();
		String nameOfOldestChild = null;
		String socialSecurityNumber = null; 
		for(int i = 1; i< persons.size(); i++) {
			if(age < persons.get(i).getChildAge()) {				
				age = (long) persons.get(i).getChildAge();	
				socialSecurityNumber = String.format("Person's SocialSecurityNumber  %s", persons.get(i).getSocialSecurityNumber());
				nameOfOldestChild =  String.format("Oldest child Name %s",persons.get(i).getPersonChildName());
			}			
		}
		pair.put(nameOfOldestChild,socialSecurityNumber);
		return pair ;
	}

	@Override
	public Person find(long id) {

		Optional<Person> person = personRepositry.findById(id);
		return person.get();
	}

}
