package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	
	//@Test (priority=1)
    @BeforeClass
	public void openApp() {

    	//open app
        
    	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Implicit wait
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		// 2. Open URL https://tutorialsninja.com/demo/

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize(); // Maximize the window
	}
    
	@AfterClass 
	public void closeApp()
	{
		driver.quit();
		
	}

}