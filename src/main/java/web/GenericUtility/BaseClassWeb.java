package web.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassWeb {
	
	public WebDriver driver;
	public FileUtility fLib = new FileUtility();
	   @BeforeClass
	   public void configBC() throws Throwable {
		System.out.println("=============Launch the Browser=======");
	   String browser = fLib.getPropertyKeyValue("Browser");
		if (browser.equalsIgnoreCase("msedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("invalid browser");
			

}
	   }
}
	   
	
