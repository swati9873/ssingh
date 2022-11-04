package pojoClassSerializationAndDeserialization;

public class Family {
 String sname;
 int[] phno;
 String[] email;
public Family(String sname, int[] phno, String[] email) {
	super();
	this.sname = sname;
	this.phno = phno;
	this.email = email;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public int[] getPhno() {
	return phno;
}
public void setPhno(int[] phno) {
	this.phno = phno;
}
public String[] getEmail() {
	return email;
}
public void setEmail(String[] email) {
	this.email = email;
}
 
}
