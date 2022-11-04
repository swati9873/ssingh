package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RequestChangeIntegerInString {
	@Test
	public void createProjectTest() {
		Random random=new Random();
		int num=random.nextInt();
		
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", 123);
		jobj.put("projectName", 87767);
		jobj.put("status", 234);
		jobj.put("teamSize", 10);
		
		baseURI= "http://localhost";
		port=8084;
		
		given()
		       .body(jobj)
		       .contentType(ContentType.JSON)
		.when()
		       .post("/addProject")
		 .then()
		      // .assertThat().contentType(ContentType.JSON)
		      // .assertThat().statusCode(201)
		       .log().all();
	}

}
