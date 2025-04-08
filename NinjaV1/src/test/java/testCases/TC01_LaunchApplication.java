package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC01_LaunchApplication extends HomePage {
	
	public TC01_LaunchApplication(WebDriver driver) {
		super(driver);
		
	}


	WebDriver driver = new ChromeDriver();
	//Open App
		@Test(priority = 1)
		void openApp(){
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			// 2. Open URL https://tutorialsninja.com/demo/
			driver.get("https://tutorialsninja.com/demo/");
			driver.manage().window().maximize();
		}
			//test
			@Test(priority = 2)
			void testLaunchApplication(){
				HomePage hp = new HomePage(driver);
				String confirmation = hp.confirmHomepage();
				Assert.assertEquals(confirmation, "Qafox.com");
			}
			
			
		@Test(priority = 3)
		void closeApp() {
			// 4) close browser
		
		driver.quit();
			
	}
	}
