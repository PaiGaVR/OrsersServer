package com.server.control;

import com.server.database.PersonsDB;
import com.server.entity.Persons;

public class Control {
	private static Control control = null;
	
	public Control() {
	}
	
	public static Control getInstance() {
		if (control == null)
			control = new Control();
		return control;
	}
	
	public boolean register(Persons person) {
		if (("" != person.getName() || "" != person.getPhone()) && "" != person.getPasswd())
			return PersonsDB.getInstance().addPerson(person);
		
		return false;
	}
	
	public Persons login(Persons person) {
		if ("" != person.getName() && "" != person.getPasswd())
			return PersonsDB.getInstance().getPerson(person.getName(), person.getPasswd());
		return null;
	}
}
