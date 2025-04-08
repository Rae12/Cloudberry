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
import utilities.DataProviders;

public class TC02_Login extends BaseClass {

	@Test(groups = {"smoke", "regression", "datadriven"}, dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	void testLogin(String email, String pwd) {
		HomePage hp = new HomePage(getDriver());
		hp.clickMyAccount();
		hp.goToLogin();
		LoginPage lp = new LoginPage(getDriver());
		lp.setEmail(email);
		lp.setPwd(pwd);
		lp.clickLogin();
		AccountPage ap = new AccountPage(getDriver());
		boolean status = ap.getMyAccountConfirmation().isDisplayed();

		if (status == true) {
			// System.out.println("Test Passed");
			// logout steps
			ap.clickMyAccountDropDown();
			ap.clickLogout();

			// Assert.assertTrue(lp.getMyAccountConfirmation().isDisplayed());
			Assert.assertTrue(status);

		} else

		{
			Assert.assertTrue(false);
		}

	}

}