package crudOperationWithBDD;

import genericUtility.BaseClassWithReqSpec;
import genericUtility.EndPointsLibrary;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class SampleTest extends BaseClassWithReqSpec{ 
	@Test
	public void getallProjectTest() {
		given().spec(requestSpec)
		.when()
		.get(EndPointsLibrary.getAllprojects)
		.then().log().all();	
		}

}
