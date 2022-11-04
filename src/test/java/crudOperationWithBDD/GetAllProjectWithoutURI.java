package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjectWithoutURI {
	@Test
	public void getallprojectTest() {
		//baseURI= "http://localhost";
		port=8084;
		when()
		      .get("/projects")
		.then()
		       .assertThat()
		      // .contentType(ContentType.JSON)
		       //.statusCode(200)
		       .log().all();

}
}
