package contactService;

import java.util.ArrayList;
import java.util.List;



import contact.Contact;

public class ContactService {

	public static List<Contact>contacts = new ArrayList<>();
	
	public boolean addContact(Contact contact) {
		
		boolean validateContact = false;
		for (Contact obj : contacts) {
			if(obj.equals(contact)) {
				validateContact = true;
			}
		}
		if (!validateContact) {
			contacts.add(contact);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean deleteContact(String contactId) {
		for (Contact obj : contacts) {
			if(obj.getContactId().equals(contactId)) {
				contacts.remove(obj);
			return true;
			}
		}
		return false;
	}
	
	public boolean update(String contactId, String firstName, String lastName, String phone, String address) {
		for (Contact obj: contacts) {
			if(obj.getContactId().equals(contactId)) {
				if(firstName != null && firstName.length() <= 10)
				obj.setFirstName(firstName);
				if(lastName != null && lastName.length() <= 10)
				obj.setLastName(lastName);
				if(phone != null && phone.length() == 10)
				obj.setPhone(phone);
				if(address != null && address.length() <= 30)
				obj.setAddress(address);
				return true;
			}
		}
		return false;	
	}
		
}
