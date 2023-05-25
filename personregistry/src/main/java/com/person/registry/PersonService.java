package com.person.registry;

import java.util.List;
import java.util.Map;




public interface PersonService {
	
	List<Person> getAllPersons();
	
	Person savePerson(Person person);
	
	Map<String,String>  getOldestChild();
	
	Person find(long id);

}
