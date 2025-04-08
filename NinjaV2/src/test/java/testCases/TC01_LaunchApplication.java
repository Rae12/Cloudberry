package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_LaunchApplication extends BaseClass {

	// test
	@Test
	public void testLaunchApplication() {

		HomePage hp = new HomePage(driver);
		String confirmation = hp.confirmHomepage();
		Assert.assertEquals(confirmation, "Qafox.com");
	}

}
