package spring.addressbook.pojos;

public class Address {
	
	private String number;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	
	public Address() {
		
	}
	
	public Address(String number, String street, String city, String state, String postalCode) {
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
