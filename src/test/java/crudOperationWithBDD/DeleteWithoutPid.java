package crudOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteWithoutPid {
	@Test
	public void deletesingleproject() {
		baseURI= "http://localhost";
		port=8084;
		when()
	          .delete("");
       // .then()
             //  .assertThat()
                  //    .contentType(ContentType.JSON)
                   //   .statusCode(200)
                  //    .log().all();
	          String expectedStatusLine="HTTP/1.1 201 ";
		Response res=given()
				.delete("");
		String actualStatusLine=res.getStatusLine();
		Assert.assertEquals(actualStatusLine, expectedStatusLine);
	}

}
