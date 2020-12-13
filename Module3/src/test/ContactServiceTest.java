package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contactService.ContactService;

class ContactServiceTest {
	
	public static List<Contact>contacts = new ArrayList<>();

	@Test
	void testContactService() {
		Contact contact = new Contact("99910", "Clark", "Kent", "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		System.out.println(contact);
		System.out.println("Entries remaining " + contacts.size());
	}
	
	@Test
	void testContactServiceIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910123123", "Clark", "Kent", "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact(null, "Clark", "Kent", "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clarkoooooo", "Kent", "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", null, "Kent", "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clark", "Kentooooooo", "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clark", null, "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServicePhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clark", "Kent", "91455512341", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServicePhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clark", "Kent", "914555123", "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServicePhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clark", "Kent", null, "344 Clinton St, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clark", "Kent", "9145551234", "344 Clinton St Apt 3D, Metropolis");
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceLastAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Contact contact = new Contact("99910", "Clark", "Kent", "9145551234", null);
		addContact(contact);
		});
	}
	
	@Test
	void testContactServiceIdExists() {
		Contact contact = new Contact("99910", "Clark", "Kent", "9145551234", "344 Clinton St, Metropolis");
		addContact(contact);
		System.out.println("Entries remaining " + contacts.size());
	}
	@Test
	public void testContactServiceAddContact() {
		ContactService services = new ContactService();
		Contact a = new Contact("99915", "Clark", "Kent", "9145551234", "344 Clinton St Apt 3D");
		Contact b = new Contact("99922", "Bruce", "Wayne", "3174449876", "1007 Mountain Dr");
		Contact c = new Contact("99965", "Tony", "Stark", "2129704133", "10880 Malibu Point");
		assertEquals(true, services.addContact(a));
		assertEquals(true, services.addContact(b));
		assertEquals(true, services.addContact(c));
	}
	@Test
	void testContactServiceDeleteContact() {
		ContactService services = new ContactService();
		Contact a = new Contact("99910", "Clark", "Kent", "9145551234", "344 Clinton St Apt 3D");
		Contact b = new Contact("99911", "Bruce", "Wayne", "3174449876", "1007 Mountain Dr");
		Contact c = new Contact("99912", "Tony", "Stark", "2129704133", "18080 Malibu Point");
		assertEquals(true, services.addContact(a));
		assertEquals(true, services.addContact(b));
		assertEquals(true, services.addContact(c));
		
		assertEquals(true, services.deleteContact("99912"));
		assertEquals(true, services.deleteContact("99911"));	
	}
	@Test
	void testContactServiceUpdateContact() {
		ContactService services = new ContactService();
		Contact a = new Contact("99914", "Clark", "Kent", "9145551234", "344 Clinton St Apt 3D");
		Contact b = new Contact("99917", "Bruce", "Wayne", "3174449876", "1007 Mountain Dr");
		Contact c = new Contact("99916", "Tony", "Stark", "2129704133", "18080 Malibu Point");
		assertEquals(true, services.addContact(a));
		assertEquals(true, services.addContact(b));
		assertEquals(true, services.addContact(c));
		
		assertEquals(true, services.update("99915", "The", "Hulk", "2129704133", "10880 Malibu Point"));
		assertEquals(true, services.update("99916", "Super", "Man", "9145551234", "232 Louis Lane"));
	
	}
	

	 
	public int getIndex(Contact contact) {
	     int index = Collections.binarySearch(contacts, contact, Contact.compareId);
	     return index;
	    }
	 
	 public boolean addContact(Contact contact) {
		 int index = getIndex(contact);
		 
		 if(index < 0 && validateContactId(contact.getContactId()) && validateFirstName(contact.getFirstName()) && validateLastName(contact.getLastName()) && validatePhone(contact.getPhone()) && validateAddress(contact.getAddress())) {
			 contacts.add(contact);
			 return true;
		 }
		 
		 return false;
	 }
	 

	 

	
	 public boolean validateContactId(String contactId) {
		 if(contactId != null && contactId.length() <= 10)
			 return true;
		 
		 return false;
	 }
	 public boolean validateFirstName(String firstName) {
		 if(firstName != null && firstName.length() <= 10)
			 return true;
		 
		 return false;
	 }
	 public boolean validateLastName(String lastName) {
		 if(lastName != null && lastName.length() <= 10)
			 return true;
		 
		 return false;
	 }
	 
	 public boolean validatePhone(String lastName) {
		 if(lastName != null && lastName.length() == 10)
			 return true;
		 
		 return false;
	 }
	 
	 public boolean validateAddress(String address) {
		 if(address != null && address.length() <= 30)
			 return true;
		 
		 return false;
	 }
	 
	 @Test
	    public void testToString() {
	        Contact t1 = new Contact("99914", "Clark", "Kent", "9145551234", "344 Clinton St, Metropolis"); 
	        String expected = "Contact ID: 99914, First Name: Clark, Last Name: Kent, Phone: 9145551234, Address: 344 Clinton St, Metropolis\n";
	        Assert.assertEquals(expected, t1.toString());
	    }
		
		@Test public void equalsFalseTest1() {
		    Contact t1 = new Contact("1", "2", "3", "1123456789", "5");
		    Object obj = new Object();
		    Assert.assertNotEquals(t1, obj);
		}
		
		@Test public void equalsFalseTest2() {
		    Contact t1 = new Contact("1", "2", "3", "1123456789", "6");
		    Contact t2 = new Contact("2", "2", "3", "1123456789", "6");
		    Assert.assertNotEquals(t1, t2);
		}
		
		@Test public void equalsTrueTest() {
			Contact t1 = new Contact("1", "2", "3", "1123456789", "5");
		    Contact t2 = new Contact("1", "2", "3", "1123456789", "5");
		    Assert.assertEquals(t1, t2);
		}
		

}
