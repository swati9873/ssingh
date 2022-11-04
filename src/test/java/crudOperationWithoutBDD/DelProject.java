package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DelProject {
	@Test
	public void getProject() {
	Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_802");
	System.out.println(response.getContentType());
	ValidatableResponse valRes = response.then();
	valRes.assertThat().contentType(ContentType.JSON);
	valRes.assertThat().statusCode(204);
	valRes.log().all();

}
}
