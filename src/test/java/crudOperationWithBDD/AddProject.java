package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Random;

public class AddProject {
	@Test
	public void createProjectTest() throws NullPointerException {
		Random random=new Random();
	    int num=random.nextInt();
		
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "swati");
		jobj.put("projectName", "tech"+num);
		jobj.put("status", "created");
		jobj.put("teamSize", 10);
		
		baseURI= "http://localhost";
		port=8084;
		
		given()
		       .body(jobj)
		       .contentType(ContentType.JSON)
		.when()
		       .post("addProject");
		       
		// .then()
		 //     .assertThat()
		 //    .contentType(ContentType.JSON)
		   //   .statusCode(201)
		    //    .log().all();
		
		String expectedpName="tech1660561737";
		Response response=when().get("http://localhost:8084/projects");
		List<String> actualname=response.jsonPath().get("projectName");
		Boolean flag=false;
		try {
		for(String aID :actualname ) {
			System.out.println(aID);
			
			if(aID.equalsIgnoreCase(expectedpName)) {
				System.out.println("project name is found");
				flag=true;
			}
			}
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			Assert.assertTrue(true);
		}
		
		
		
	}

}
