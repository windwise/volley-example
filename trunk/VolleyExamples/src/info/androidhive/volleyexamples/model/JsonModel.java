package info.androidhive.volleyexamples.model;

public class JsonModel {

	private String email;
	private String name;
	private PhoneModel phone;
	
	public class PhoneModel {
		public String home;
		public String mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PhoneModel getPhone() {
		return phone;
	}

	public void setPhone(PhoneModel phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "name: " + getName() + " email: " + getEmail() + " home: " + getPhone().home + " mobile: " + getPhone().mobile; 
	}
	
}
