package requestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.genericUtility.AddProjectPOJOTest;

public class PostGetPutDel {
	@Test
	public void postgetputdel() {
		Random random=new Random();
		int Random=random.nextInt(1000);
		
		baseURI="http://localhost";
		port=8084;
		//add
	    AddProjectPOJOTest pojo=new AddProjectPOJOTest("shivani","tech"+Random,"created",5);
	    Response response= given()
			  .body(pojo).contentType(ContentType.JSON).when().post("/addProject");
	           response.then().log().all();
	    String proId=response.jsonPath().get("projectId");
	    //get
	    given()
        .pathParam("projectId", proId)
        .when().get("projects/{projectId}")
        .then().log().all();
       
	    //update
	    AddProjectPOJOTest upd=new AddProjectPOJOTest("swati","abc","on going",10);
	    given().pathParam("projectId", proId).body(upd).contentType(ContentType.JSON)
	    .when().put("/projects/{projectId}")
	    .then().log().all();
       //delete
	    given()
   	    .pathParam("projectId", proId)
    	.when().delete("projects/{projectId}")
   	    .then().log().all();
	    
		
	}

}
