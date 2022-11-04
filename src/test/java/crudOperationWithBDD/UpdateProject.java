package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void createProjectTest() {
		
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "sw");
		jobj.put("projectName", "techm1");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 7);
		
		baseURI= "http://localhost";
		port=8084;
		
		given()
		       .body(jobj)
		       .contentType(ContentType.JSON)
		.when()
		       .put("/projects/TY_PROJ_803")
		 .then()
		       .assertThat()
		       .contentType(ContentType.JSON)
		       .statusCode(200)
		       .log().all();
	}


}
