package spring.addressbook.pojos;

import java.util.List;

public class Entry {
	
	private String id;
	
	private String firstName;
	private String lastName;
	
	private Address address;
	
	private PhoneNumber phoneNumber;
	private EmailAddress emailAddress;
	
	public Entry() {
		
	}
	
	public Entry(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber( PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
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

}
