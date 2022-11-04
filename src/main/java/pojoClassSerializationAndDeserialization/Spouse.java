package pojoClassSerializationAndDeserialization;

public class Spouse {
	String eName;
	int phoneNo;
	String email;
	public Spouse(String eName, int phoneNo, String email) {
		super();
		this.eName = eName;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
