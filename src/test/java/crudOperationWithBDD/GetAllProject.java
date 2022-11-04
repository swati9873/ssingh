package crudOperationWithBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetAllProject {
	@Test
	public void getallprojectTest() {
		baseURI= "http://localhost";
		port=8084;
		when()
		      .get("/projects");
		      
	
		String expectedStatusLine="HTTP/1.1 200 ";
		Response res=given()
				.get("projects");
		String actualStatusLine=res.getStatusLine();
		Assert.assertEquals(actualStatusLine, expectedStatusLine);
		}
		
		
	
	}

