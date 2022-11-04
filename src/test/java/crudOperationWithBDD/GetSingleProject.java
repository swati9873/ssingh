package crudOperationWithBDD;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProject {
	@Test
	public void getsingleproject() {
		
		baseURI= "http://localhost";
		port=8084;
		when()
		      .get("/projects/TY_PROJ_005")
	    .then()
	           .assertThat()
	                        .contentType(ContentType.JSON)
	                        .statusCode(200)
	                        .log().all();
		      
		
	}

}
