package spring.addressbook.pojos;

public class EmailAddress {
	
	private String alias;
	private String address;
	
	public EmailAddress() {
		
	}
	
	public EmailAddress(String alias, String address) {
		this.alias = alias;
		this.address = address;
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
