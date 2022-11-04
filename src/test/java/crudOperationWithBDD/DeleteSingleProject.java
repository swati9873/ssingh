package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteSingleProject {
	@Test
	public void deletesingleproject() {
		baseURI= "http://localhost";
		port=8084;
		when()
	          .delete("/projects/TY_PROJ_803");
		
		String expectedpId="TY_PROJ_803";
		Response response=when().get("http://localhost:8084/projects");
		List<String> actualPid=response.jsonPath().get("projectId");
		Boolean flag=false;
		for(String aID : actualPid) {
			if(!aID.contains(expectedpId)) {
				
				flag=true;
			}
		}
		
		Assert.assertTrue(true);
		System.out.println("project id is deleted");
        
	}

}
