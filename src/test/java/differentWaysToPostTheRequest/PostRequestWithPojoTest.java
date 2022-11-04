package differentWaysToPostTheRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.genericUtility.AddProjectPOJOTest;

public class PostRequestWithPojoTest {
@Test
	public void createProjectTest() {
	//	AddProjectPOJOTest pj=new AddProjectPOJOTest("swati","tysfs1","created",5);
		given()
		      .contentType(ContentType.JSON)
		//      .body(pj)
		.when()
		      .post("http://localhost:8084/addProject")
		.then()
		       .assertThat().contentType(ContentType.JSON)
		       .statusCode(201)
		       .log().all();
		      
	}
}
