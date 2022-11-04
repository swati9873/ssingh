package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetSingleProject {
	@Test
	public void getProject() {
	Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_213");
	System.out.println(response.getContentType());
	ValidatableResponse valRes = response.then();
	valRes.assertThat().contentType(ContentType.JSON);
	valRes.assertThat().statusCode(200);
	valRes.log().all();

}
}
