package differentWaysToPostTheRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingHashMapTest {
	@Test
	public void createProjectHashMapTest() {
		HashMap hp= new HashMap();
		hp.put("createdBy", "swati");
		hp.put("projectName", "techmax96");
		hp.put("status", "created");
		hp.put("teamsize", 8);
		
		baseURI= "http://localhost";
		port=8084;
	given()
	       .body(hp)
	       .contentType(ContentType.JSON)
	.when()
	       .post("/addProject")
	       
	 .then()
	       .assertThat()
	       .statusCode(201)
	       .contentType(ContentType.JSON)
	       .log().all();
	
		
	}

}
