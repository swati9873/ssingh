package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	@Test
	public void authentication() {
		given()
		.auth().oauth2("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")
		.when()
		 .get("https://api.github.com/user/repos")
	    .then()
	           .assertThat().statusCode(200).log().all();
		 
		 

}
}
