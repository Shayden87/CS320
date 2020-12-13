package contact;

import java.util.Comparator;



public class Contact {
	
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		if(contactId == null || contactId.length()>10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if(phone == null || phone.length()!=10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public String getContactId() {
		return contactId;
	}
	public void setContactID(String contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Contact a = (Contact) obj;
		return getContactId().equals(a.getContactId());
	}
	
	public static Comparator<Contact> compareId = new Comparator<Contact>() {
		
		public int compare(Contact a1, Contact a2) {
			return a1.getContactId().compareTo(a2.getContactId());
		}
	};
	
	 public String toString() {
	        return "Contact ID: " + getContactId() + ", First Name: " + getFirstName() + ", Last Name: " + getLastName() + ", Phone: " + getPhone() + ", Address: " + getAddress() + "\n";
	    }
}

