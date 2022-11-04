package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.genericUtility.AddProjectPOJOTest;

public class PostAndDel {
	@Test
	public void PostAndDelTest() {
		Random random=new Random();
		int Random=random.nextInt(1000);
		
		baseURI="http://localhost";
		port=8084;
	  AddProjectPOJOTest pojo=new AddProjectPOJOTest("swat","tech"+Random,"created",5);
	 Response response= given()
			  .body(pojo).contentType(ContentType.JSON).when().post("/addProject");
	 String proId=response.jsonPath().get("projectId");
	 given()
	 .pathParam("projectId", proId)
	 .when()
	 .delete("projects/{projectId}")
	 .then().log().all();
	  
	}

}
