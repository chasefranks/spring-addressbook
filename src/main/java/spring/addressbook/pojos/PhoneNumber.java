package spring.addressbook.pojos;

public class PhoneNumber {
	
	private String alias;
	private String number;
	
	public PhoneNumber() {
		
	}
	
	public PhoneNumber(String alias, String number) {
		this.alias = alias;
		this.number = number;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
