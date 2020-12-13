package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {
	
	@Test
	void testContact() {
		Contact contact = new Contact("Halpert10", "Jim", "Halpert", "5704576745", "6407 Cyprus Dr, Scranton PA");
		assertTrue(contact.getContactId().equals("Halpert10"));
		assertTrue(contact.getFirstName().equals("Jim"));
		assertTrue(contact.getLastName().equals("Halpert"));
		assertTrue(contact.getPhone().equals("5704576745"));
		assertTrue(contact.getAddress().equals("6407 Cyprus Dr, Scranton PA"));
	}

	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("DwightSchrute", "Dwight", "Schrute", "5708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Dwight", "Schrute", "5708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Dwight01", "DwightSchrute", "Schrute", "5708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("DwightSchrute", null, "Schrute", "5708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Dwight01", "Dwight", "SchruteDwight", "5708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Dwight01", "Dwight", null, "5708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testPhoneAboveTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Dwight01", "Dwight", "Schrute", "15708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testPhoneBelowTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Dwight01", "Dwight", "Schrute", "708441240", "345 Beet Rd, Scranton PA");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Dwight01", "Dwight", "Schrute", "5708441240", "1345 Beet Rd, Scranton PA 18503");
		});
	}
	
	@Test
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Dwight01", "Dwight", "Schrute", "5708441240", null);
		});
	}

}
