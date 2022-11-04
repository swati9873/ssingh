package datadDrivenTestingWithDataprovider;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.genericUtility.AddProjectPOJOTest;
import pojoClass.genericUtility.FetchDataFromExcel;

import static io.restassured.RestAssured.*;

import java.io.IOException;


public class AddProjectUsingDataProviderTest {
	@Test(dataProvider="TestBody")
	public void addProjectTest(String createdBy,String projectName,String status,int teamsize) {
		AddProjectPOJOTest apj=new AddProjectPOJOTest(createdBy, projectName, status, teamsize);
		given()
		      .contentType(ContentType.JSON)
		      .body(apj)
		.when()
		      .post("http://localhost:8084/addProject")
		.then()
		      .assertThat()
		      .contentType(ContentType.JSON)
		      .log().all();
		}

	@DataProvider
	public Object[][] TestBody() throws EncryptedDocumentException, IOException {
		Object [][] obj=new Object[2][4];
		obj[0][0]=FetchDataFromExcel.getStringExcelData("Sheet1", 0,0);
		obj[0][1]=FetchDataFromExcel.getStringExcelData("Sheet1", 0, 1);
		obj[0][2]=FetchDataFromExcel.getStringExcelData("Sheet1", 0, 2);
	    obj[0][3]=FetchDataFromExcel.getNumericExcelData("Sheet1", 0, 3);
	    obj[1][0]=FetchDataFromExcel.getStringExcelData("Sheet1", 1, 0);
	    obj[1][1]=FetchDataFromExcel.getStringExcelData("Sheet1", 1, 1);
	    obj[1][2]=FetchDataFromExcel.getStringExcelData("Sheet1", 1, 2);
	    obj[1][3]=FetchDataFromExcel.getNumericExcelData("Sheet1", 1, 3);
	    return obj;

}
}
