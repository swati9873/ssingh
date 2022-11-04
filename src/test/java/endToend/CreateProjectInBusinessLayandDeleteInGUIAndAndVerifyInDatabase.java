package endToend;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DatabaseLibrary;
import genericUtility.EndPointsLibrary;
import genericUtility.JavaLibrary;
import genericUtility.RestAssuredLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.response.Response.*;
import pojoClass.genericUtility.AddProjectPOJOTest;

public class CreateProjectInBusinessLayandDeleteInGUIAndAndVerifyInDatabase extends BaseClass{
		@Test
		public void AddProjectTest() throws Throwable {
			
			
				//create pre requesites
				JavaLibrary jlib=new JavaLibrary();
				DatabaseLibrary dlib=new DatabaseLibrary();
				RestAssuredLibrary rest=new RestAssuredLibrary();
				String value="data"+jlib.getrandomNumber();
				AddProjectPOJOTest pLib=new AddProjectPOJOTest("md", value, "pass", 4);
			
				//send the request

				 Response response=given()
		                 .body(pLib)
		                 .contentType(ContentType.JSON)
		                 .when()
		                 .post(EndPointsLibrary.createProject);
 
			
			
			//login to application
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			driver.get("http://localhost:8084");
			driver.findElement(By.name("username")).sendKeys("rmgyantra");
			driver.findElement(By.name("password")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			Thread.sleep(5000);
		 driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+value+"']/following-sibling::td/a/i[@title='Delete']")).click();
		 Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@value='Delete']")) .click();
			//driver.quit();
			
			
		//database Verification
			dlib.connectDB();
			
			String query = "select * from project";
			dlib.execyteQuery(query);
			
			String querry= "select * from project";
			String expectedData = value;
			String actualdata = dlib.readDataFromDBAndVerify(query, 1, expectedData);
			Assert.assertNotEquals(expectedData, actualdata);
			//close connection
			dlib.closeDB();
			driver.close();
			}
}
