package endToend;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DatabaseLibrary;
import genericUtility.EndPointsLibrary;
import genericUtility.JavaLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class CreateProjectAndVerify extends BaseClass {
	@Test
	public void AddProjectTest() throws Throwable {
	
		JavaLibrary jlib=new JavaLibrary();
		DatabaseLibrary dlib=new DatabaseLibrary();
		String value="data"+jlib.getrandomNumber();
		JSONObject obj = new JSONObject();
	   //createProject
		
		obj.put("createdBy", "swati");
		obj.put("projectName", value);
		obj.put("status", "created");
		obj.put("teamSize", 5);
		
		
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		 
		.when()
		.post(EndPointsLibrary.createProject)
		
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
		//login to application
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		//verification
     //  	String name="TY_PROJ_001";
		Thread.sleep(5000);
		 String ele = driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+value+"']")).getText();
		 //table/tbody/tr/td[text()='"+name+"']/table[@class='table table-striped table-hover']/tbody/tr[1]/td[1
	if(value.equals(ele)) {
		System.out.println("project created");
	}
	else {
		System.out.println("project is not present");
	}
	//driver.quit();
	//database Verification
	dlib.connectDB();
	
	String query = "select * from project";
	dlib.execyteQuery(query);
	
	String querry= "select * from project";
	String expectedData = value;
	dlib.readDataFromDBAndVerify(query, 4, expectedData);
	//close connection
	dlib.closeDB();
	driver.close();
}
	


}
