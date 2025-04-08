package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC05_AddToWish extends BaseClass {

	@Test (groups = {"regression"})
	public void testAddAnItemToWishList() {

		// Navigate and select product
		HomePage hp = new HomePage(getDriver());
		hp.navigateToLaptopsAndNotebooks();
		CategoryPage cp = new CategoryPage(getDriver());
		cp.selectProduct();
		AddToCartPage atcp = new AddToCartPage(getDriver());
		atcp.addToWishList();
		Assert.assertTrue(atcp.isWishListSuccessMessageDisplayed());
		// Assert.assertTrue(atcp.isWishListSuccessMessageDisplayed(), "Success message
		// not displayed");

	}
}