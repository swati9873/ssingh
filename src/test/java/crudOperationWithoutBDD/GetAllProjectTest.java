package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectTest {
	@Test
	public void getAllProject() {
		Response response = RestAssured.get("http://localhost:8084/projects");
		System.out.println(response.getContentType());
		ValidatableResponse valRes = response.then();
		valRes.assertThat().contentType(ContentType.JSON);
		valRes.assertThat().statusCode(200);
		//valRes.log().all();
		response.prettyPrint();
		//response.prettyPeek();
	}

	
}
