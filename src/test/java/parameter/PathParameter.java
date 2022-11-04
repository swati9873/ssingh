package parameter;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
@Test
public class PathParameter {
	
	public void pathParameter() {
		String proId="TY_PROJ_209";
		given()
		.pathParam("projectID", proId)
		.when().get("http://localhost:8084/projects/{projectID}")
		
		.then()
		.log().all();
	}

}
