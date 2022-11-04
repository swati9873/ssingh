package endToend;

import genericUtility.BaseClass;
import genericUtility.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.genericUtility.AddProjectPOJOTest;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateProjVerifyInDB extends BaseClass{
	
	@Test
	public void CreateProjVerifyInDBTest() throws Throwable {
	//step1:create pre requisites
		AddProjectPOJOTest pLib=new AddProjectPOJOTest("sw","rmgy"+jLib.getrandomNumber(),"created",5);
	
	//Step2: send the request
	 Response response=given()
			                 .body(pLib)
			                 .contentType(ContentType.JSON)
			                 .when()
			                 .post(EndPointsLibrary.createProject);
	 
	 //Step:3 capture the project id
	String expData= rLib.getJsonData(response, "projectId");
	Reporter.log(expData,true);
	
	//Step 4: validate the id in response
	String query="select *from project";
	String actData=dLib.readDataFromDBAndVerify(query, 1, expData);
    Assert.assertEquals(expData, actData);
	}
	 

}
