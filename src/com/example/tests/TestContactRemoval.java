package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactRemoval extends TestBase{
	
	@Test(priority = 2)
	public void deleteContact(){
		Contact contact = new Contact().setLastName("tester");
		app.getContactHelper().removeContact(contact);
	}

}
