package pojoClassSerializationAndDeserialization;

public class EmployeeDetailsWithArray {
	//step1:Declare the variable globally
	String[] eName;
	String[] eId;
	String[] phoneNo;
	String[] email;
	String[] address;
	//create a constructor for initialization
	public EmployeeDetailsWithArray(String[] eName, String[] eId, String[] phoneNo, String[] email, String[] address) {
		super();
		this.eName = eName;
		this.eId = eId;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
	}
	
	//triggering execution during serialization
	public EmployeeDetailsWithArray()
	{
	}

	public String[] geteName() {
		return eName;
	}

	public void seteName(String[] eName) {
		this.eName = eName;
	}

	public String[] geteId() {
		return eId;
	}

	public void seteId(String[] eId) {
		this.eId = eId;
	}

	public String[] getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String[] phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}
	
	}
	


	
