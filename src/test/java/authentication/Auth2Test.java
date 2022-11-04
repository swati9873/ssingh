package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2Test {
@Test
	public void authentication() {

		Response response =  given()
				.formParam("client_id", "Branch1")
				.formParam("client_secret", "a9da0df1805d4fd86d089ec73b2cba85")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://localhost:8084")
				.formParam("code", " 3919")
				
				.when()
				      .post("http://coop.apps.symfonycasts.com/token");
		    response.then().log().all();
		    
		String token =   response.jsonPath().get("access_token");
		System.out.println(token);
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3919)
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count").then().log().all();
		    
		   
		          
		   
		    



	}
}
