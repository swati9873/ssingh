package genericUtility;

import java.sql.SQLException;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClass {
	public DatabaseLibrary dLib=new DatabaseLibrary();
	public JavaLibrary jLib=new JavaLibrary();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	   
	@BeforeSuite
	public void bsConfig() throws SQLException {
		System.out.println("========================connect to DB========================");
		dLib.connectDB();
		baseURI="http://localhost";
		port=8084;
		
		
			}
	
	public void configAS() throws SQLException {
		System.out.println("========================close DB========================");
		dLib.closeDB();

}
}