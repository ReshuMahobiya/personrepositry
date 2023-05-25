package com.person.registry;


import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(produces="application/json")
@CrossOrigin(origins="*")
public class PersonRestController {
	
		@Autowired
		private PersonService personService;
	
	 	@GetMapping("/allPerson")
	    public List<Person> get() {
	         
	 		return personService.getAllPersons();
	    }
	 	
	 	@PostMapping("/savePerson")
	 	public ResponseEntity<Person> savePerson(@RequestBody Person person  ) {
	 		
	 		Person savedPerson = personService.savePerson(person);
	 		if (savedPerson == null) {
	 	        return ResponseEntity.notFound().build();
	 	    } else {
	 	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	 	          .path("/{socialSecurityNumber}")
	 	          .buildAndExpand(savedPerson.getSocialSecurityNumber())
	 	          .toUri();

	 	        return ResponseEntity.created(uri)
	 	          .body(savedPerson);
	 	    }
	 	}
	
	 	@GetMapping("/person/{id}")
	 	public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
	 		Person foundPerson = personService.find(id);
	 	    if (foundPerson == null) {
	 	        return ResponseEntity.notFound().build();
	 	    } else {
	 	        return ResponseEntity.ok(foundPerson);
	 	    }
	 	}
	 	
		@GetMapping("/oldestchildAge")
	 	public ResponseEntity<Map<String,String>> getOldestChild() {
			Map<String,String> oldestchild = personService.getOldestChild();
	 	    if (oldestchild == null) {
	 	        return ResponseEntity.notFound().build();
	 	    } else {
	 	        return ResponseEntity.ok(oldestchild);
	 	    }
	 	}
}
