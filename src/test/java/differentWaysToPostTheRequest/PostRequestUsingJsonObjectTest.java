package differentWaysToPostTheRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestUsingJsonObjectTest {
	@Test
	public void createProjectTest() {
		Random random=new Random();
		int num=random.nextInt();
		
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "swati");
		jobj.put("projectName", "techmax"+num);
		jobj.put("status", "created");
		jobj.put("teamSize", 10);
		
		baseURI= "http://localhost";
		port=8084;
		
		given()
		       .body(jobj)
		       .contentType(ContentType.JSON)
		.when()
		       .post("/addProject")
		 .then()
		       .assertThat().contentType(ContentType.JSON)
		       .assertThat().statusCode(201)
		       .log().all();
	}


}
