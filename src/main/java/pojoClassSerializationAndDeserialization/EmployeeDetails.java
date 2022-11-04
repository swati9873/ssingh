package pojoClassSerializationAndDeserialization;

public class EmployeeDetails {
	String eName;
	String eId;
	String phoneNo;
	String email;
	String address;
	//create constructor for initialization
	public EmployeeDetails(String eName, String eId, String phoneNo, String email, String address) {
		
		this.eName = eName;
		this.eId = eId;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}
	//triggering execution during serialization or deserialization
	public EmployeeDetails() {
		
	}
	//setter and getter for acess
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
