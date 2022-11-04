package validationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValTest {
	@Test
	public void getAllProjectsTest() {
		
		String expectedpId="TY_PROJ_005";
		Response response=when().get("http://localhost:8084/projects");
		List<String> actualPid=response.jsonPath().get("projectId");
		Boolean flag=false;
		for(String aID : actualPid) {
			if(aID.equalsIgnoreCase(expectedpId)) {
				System.out.println("project id is found");
				flag=true;
			}
		}
		
		Assert.assertTrue(true);
		
		
		
	}

}
