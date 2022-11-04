package pojoClassSerializationAndDeserialization;

public class CreateContact {
	
	String fn;
	String ln;
	int[] phno;
	String email;
	String companyname;
	String url;
	String Address;
	String birthdate;
	String socialnetwork;
	String[] relatedname;
	Object family;

	public CreateContact(String fn, String ln, int[] phno, String email, String companyname, String url, String address,
			String birthdate, String socialnetwork, String[] relatedname, Object family) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.phno = phno;
		this.email = email;
		this.companyname = companyname;
		this.url = url;
		Address = address;
		this.birthdate = birthdate;
		this.socialnetwork = socialnetwork;
		this.relatedname = relatedname;
		this.family = family;
	}
	public CreateContact()
	{
	
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public int[] getPhno() {
		return phno;
	}
	public void setPhno(int[] phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getSocialnetwork() {
		return socialnetwork;
	}
	public void setSocialnetwork(String socialnetwork) {
		this.socialnetwork = socialnetwork;
	}
	public String[] getRelatedname() {
		return relatedname;
	}
	public void setRelatedname(String[] relatedname) {
		this.relatedname = relatedname;
	}
	public Object getFamily() {
		return family;
	}
	public void setFamily(Object family) {
		this.family = family;
	}
	

}
