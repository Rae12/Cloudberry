package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC02_Login extends BaseClass{
	
	

	@Test
	void testLogin() {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount(); //click on MyAccount
		hp.goToLogin(); //click on Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("sid@cloudberry.services"); // set email
		lp.setPwd("Test123"); // set password
		lp.clickLogin(); //clicks on login
		AccountPage ap = new AccountPage(driver);
		boolean status = ap.getMyAccountConfirmation().isDisplayed(); //Verufy account page
		Assert.assertTrue(status);

	}

	

}