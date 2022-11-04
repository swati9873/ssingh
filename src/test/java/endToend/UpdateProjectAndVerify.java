package endToend;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DatabaseLibrary;
import genericUtility.EndPointsLibrary;
import genericUtility.JavaLibrary;
import genericUtility.RestAssuredLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.genericUtility.AddProjectPOJOTest;

public class UpdateProjectAndVerify extends BaseClass {
	
	@Test
	public void UpdateVerify() throws Throwable {
		JavaLibrary jlib=new JavaLibrary();
		DatabaseLibrary dlib=new DatabaseLibrary();
		RestAssuredLibrary rest=new RestAssuredLibrary();
		AddProjectPOJOTest add=new AddProjectPOJOTest("sd", "lhjg"+jlib.getrandomNumber(), "pass", 4);
		
		//send the request

		Response res = given()
				.body(add)
				.contentType(ContentType.JSON)
				.when()
				.put(EndPointsLibrary.updateProject);
		
		
		//capture the project id
		String expectedadata = rest.getJsonData(res, "projectId");
		Reporter.log(expectedadata,true);
		
		String querry="select * from project";
		String actual=dlib.readDataFromDBAndVerify(querry, 1, expectedadata);
		Assert.assertEquals(expectedadata, actual);
	}
}
