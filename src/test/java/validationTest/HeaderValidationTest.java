package validationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest {
    @Test
	public void headerValidationTest() {
    	baseURI="http://localhost";
    	port=8084;
    	String expectedContentType="application/json";
    	String expectedVary="Access-Control-Request-Headers";
    	String expectedPragma="no-cache";
    	Response res=when().get("projects");
    	String actualContentType=res.getContentType();
    	String actualVary=res.getHeader("Vary");
    	String actualPragma=res.getHeader("Pragma");
    	res.then().log().all();
    	Assert.assertEquals(expectedContentType, actualContentType);
    	Assert.assertEquals(expectedVary, actualVary);
    	Assert.assertEquals(expectedPragma, actualPragma);
    	
		
	}
}
