package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	
	@Test(priority = 1)
	public void shouldCreateContactWithValidData(){
		Contact contact = new Contact().setFirstName("tester").setLastName("tester");
		app.getContactHelper().createContact(contact);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Contact createdContact =  app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);
	}

}
