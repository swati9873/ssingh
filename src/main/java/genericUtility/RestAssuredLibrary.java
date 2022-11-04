package genericUtility;
/**
 *  Consist of methods of Rest assured tool
 *  @author 
 *  
 */
import io.restassured.response.Response;

public class RestAssuredLibrary {
	/**
	 * This method will return json data from the corresponding
	 */
	
	public String getJsonData(Response response,String path) {
		String jsonData=response.jsonPath().get(path);
		return jsonData;
		
	}
	
	

}
