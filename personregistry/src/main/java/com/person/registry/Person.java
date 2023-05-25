package com.person.registry;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Person{
	
	@Id
	Long socialSecurityNumber;
    String personName;
    String personSpouseName;
    String personChildName;
    int childAge;

    
 	public Long getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(Long socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonSpouseName() {
		return personSpouseName;
	}
	public void setPersonSpouseName(String personSpouseName) {
		this.personSpouseName = personSpouseName;
	}
	public String getPersonChildName() {
		return personChildName;
	}
	public void setPersonChildName(String personChildName) {
		this.personChildName = personChildName;
	}
	public int getChildAge() {
		return childAge;
	}
	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}


    
    
}
