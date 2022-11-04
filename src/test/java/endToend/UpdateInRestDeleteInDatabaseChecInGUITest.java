package endToend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.DatabaseLibrary;
import genericUtility.EndPointsLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.List;

import pojoClass.genericUtility.AddProjectPOJOTest;

public class UpdateInRestDeleteInDatabaseChecInGUITest {
	@Test
	public void validationTest() throws InterruptedException {
		DatabaseLibrary dLib=new DatabaseLibrary();
		
		//update in rest(Business layer)
		String pID="TY_PROJ_207";
		String pName="project";
		AddProjectPOJOTest pLib=new AddProjectPOJOTest("md", pName, "completed", 4);
		given()
		       .body(pLib)
		       .contentType(ContentType.JSON)
        .when()
             .put(EndPointsLibrary.updateProject+pID);
		
		
		//delete in database
		String query="delete from project where project_id="+pID;
		
		//check in GUI
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		for (WebElement ele : elements) {
			if (pID.equals(ele)) {
				System.out.println("Not Deleted");
				
			}
			else {
				System.out.println("Deleted");
				break;
			}
		}
		driver.quit();
		
	
		
		
		
		
		
		
	}
	
	

}
