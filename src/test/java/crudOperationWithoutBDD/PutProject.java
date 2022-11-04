package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutProject {
	@Test
	public void putProject() {
		//create the body using json simple
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "shivani");
		jobj.put("projectName", "tyss_12");
		jobj.put("status", "Created");
		jobj.put("teamSize", 7);
		//precondition (body and content type)
		RequestSpecification reqsp=RestAssured.given();
		reqsp.body(jobj);
		reqsp.contentType(ContentType.JSON);
		//Actions
		Response response = reqsp.put("http://localhost:8084/projects/TY_PROJ_802");
		System.out.println(response.getContentType());
		ValidatableResponse ValResp=response.then();
		ValResp.assertThat().contentType(ContentType.JSON);
		ValResp.assertThat().statusCode(200);
		ValResp.log().all();
	}

}
