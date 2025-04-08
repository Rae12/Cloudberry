package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC05_AddToWish extends BaseClass {

	@Test
	public void testAddToCart() {

		// Navigate and select product
		HomePage hp = new HomePage(driver);
		hp.navigateToLaptopsAndNotebooks();
		CategoryPage cp = new CategoryPage(driver);
		cp.selectProduct();
		AddToCartPage atcp = new AddToCartPage(driver);
		atcp.addToWishList();
		Assert.assertTrue(atcp.isWishListSuccessMessageDisplayed());
		// Assert.assertTrue(atcp.isWishListSuccessMessageDisplayed(), "Success message
		// not displayed");

	}
}