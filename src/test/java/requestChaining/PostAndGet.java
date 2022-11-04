package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.genericUtility.AddProjectPOJOTest;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostAndGet {
@Test	
public void postAndDeleteTest() {
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
     .get("projects/{projectId}")
     .then().log().all();
  
		  
		  
  
	
}
}
