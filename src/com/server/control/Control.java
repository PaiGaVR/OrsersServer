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
		PersonsDB.getInstance().addPerson(person);
		return true;
	}
}
