package pojoClassSerializationAndDeserialization;

public class EmployeeDetailWithObjectArray {
	String eName;
	String eId;
	String[] phoneNo;
	String email;
	String address;
	Object Spouse;
	public EmployeeDetailWithObjectArray(String eName, String eId, String[] phoneNo, String email, String address,Object spouse) {
	
		this.eName = eName;
		this.eId = eId;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		Spouse = spouse;
	}
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
	public String[] getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String[] phoneNo) {
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
	public Object getSpouse() {
		return Spouse;
	}
	public void setSpouse(Object spouse) {
		Spouse = spouse;
	}
	

}
