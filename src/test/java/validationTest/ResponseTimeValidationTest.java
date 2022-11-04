package validationTest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationTest {
	@Test
	public void ValRespTime() {
		baseURI="http://localhost";
		port=8084;
		when().get("projectss")
		.then().assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);

	}
}
