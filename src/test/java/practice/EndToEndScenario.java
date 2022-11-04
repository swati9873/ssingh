package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class EndToEndScenario {
	@Test
	public void createProjectTest() throws InterruptedException, SQLException {
		Random random=new Random();
		int num=random.nextInt();
		String name="New"+num;
		
		//Create project in business layer
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "swati");
		jobj.put("projectName", name);
		jobj.put("status", "created");
		jobj.put("teamSize", 10);
		
		baseURI= "http://localhost";
		port=8084;
		
		given()
		       .body(jobj)
		       .contentType(ContentType.JSON)
		.when()
		       .post("/addProject")
		 .then()
		       .log().all();
	
	   // checking the project in GUI
        WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		String ele=driver.findElement(By.xpath("//table/tbody/tr/td[text()='"+name+"']")).getText();
		
		if(name.equals(ele)) {
			System.out.println("Project is present");
		}
		driver.quit();
	
	// checking the project in Database
	Driver driverRef = new Driver();
	Connection con=null;
	DriverManager.registerDriver(driverRef);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	Statement state = con.createStatement();
	String query="select * from project";
	String expdata = name;
	ResultSet result=state.executeQuery(query);
	boolean flag=false;
	
	//validate
	while (result.next()) {
		String actdata=result.getString(4);
		if(actdata.equalsIgnoreCase(expdata)) {
			System.out.println(actdata);
			flag = true;
			break;
		}
	}
	if(flag) {
		System.out.println("data present");
	}else {
		System.out.println("data not present");
	}
    con.close();
}
}
