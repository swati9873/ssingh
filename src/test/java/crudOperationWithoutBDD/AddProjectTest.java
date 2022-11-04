package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
@Test

public void createProjectTest()
{
	//create the body using json simple
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "swati");
	jobj.put("projectName", "tysss11n");
	jobj.put("status", "Created");
	jobj.put("teamSize", 5);
	//precondition (body and content type)
	RequestSpecification reqsp=RestAssured.given();
	reqsp.body(jobj);
	reqsp.contentType(ContentType.JSON);
	//Actions
	Response response = reqsp.post("http://localhost:8084/addProject");
	ValidatableResponse ValResp=response.then();
	ValResp.assertThat().contentType(ContentType.JSON);
	ValResp.assertThat().statusCode(201);
	ValResp.log().all();
	
	
	
	
	
	
}
}
