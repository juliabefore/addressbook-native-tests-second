package com.example.fw;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.firstName)
			.send("TDBEdit11", contact.lastName);
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add").winWaitAndActivate("Add Contact", "", 5000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
			.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
			.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
	}

	public void removeContact(Contact contact) {
		initContactRemoval();
		submitContactDelete();
		checkContactRemoval(contact);
	}

	private void checkContactRemoval(Contact contact) {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.send("TEdit1", contact.lastName)
		.click("Search")
		.winWaitAndActivate("Information", "", 5000)
		.click("OK");
	}

	private void submitContactDelete() {
		manager.getAutoItHelper()
		.winWaitAndActivate("Confirm", "", 5000)
		.click("&Yes");
	}

	private void initContactRemoval() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TListView1")
		.send("{DOWN}{SPACE}")
 		.click("Delete");
	}

}
