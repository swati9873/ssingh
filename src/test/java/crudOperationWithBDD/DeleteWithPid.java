package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteWithPid {
	@Test
	public void deletesingleproject() {
		baseURI= "http://localhost";
		port=8084;
		when()
	          .delete("/projects/TY_PROJ_410")
        .then()
               .assertThat()
                      .contentType(ContentType.JSON)
                      //.statusCode(200)
                      .log().all();
}
}
