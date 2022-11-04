package genericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassWithReqSpec {
	public JavaLibrary jLib=new JavaLibrary();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public DatabaseLibrary dLib=new DatabaseLibrary();
	public RequestSpecification requestSpec;
	public ResponseSpecification responSpec;
	/**
	 * RequestSpecBuilder and ResponseSpecBuilder are classes in restassured Library
	 * with the help of which we can store common Actions in both request
	 * and response
	 * @throws SQLException 
	 */
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		dLib.connectDB();
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("http://localhost");
		builder.setPort(8084);
		builder.setContentType(ContentType.JSON);
		requestSpec=builder.build();
	}
	@AfterSuite
	public void asConfig() throws SQLException {
		dLib.closeDB();
		ResponseSpecBuilder builder=new ResponseSpecBuilder();
		responSpec=builder.expectContentType(ContentType.JSON).build();
	}

}
