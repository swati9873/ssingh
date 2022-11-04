package differentWaysToPostTheRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingJsonFileTest {
	@Test
	public void createPojoTest() {
		File file=new File("./src/test/resources/TestData.json");
		given()
		       .body(file)
		       .contentType(ContentType.JSON)
	    .when()
	           .post("http://localhost:8084/addProject")
	     .then()
	            .assertThat()
	            .contentType(ContentType.JSON)
	            .statusCode(201)
	            .log().all();
		 
	}

}
