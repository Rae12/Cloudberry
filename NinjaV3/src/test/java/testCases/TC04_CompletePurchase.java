package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CategoryPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC04_CompletePurchase extends BaseClass {

	@Test (groups = {"smoke", "regression"})
	public void testCompletePurchase() {

		// Navigate to product and add to cart
		// Navigate and select product
		HomePage hp = new HomePage(getDriver());
		hp.navigateToLaptopsAndNotebooks();
		CategoryPage cp = new CategoryPage(getDriver());
		cp.selectProduct();
		AddToCartPage addToCartPage = new AddToCartPage(getDriver());

		// Set delivery date and add to cart
		addToCartPage.setDeliveryDate();
		addToCartPage.clickAddToCart();

		// Proceed to checkout
		addToCartPage.goToCheckout();

		// Login to complete purchase

		LoginPage lp = new LoginPage(getDriver());
		lp.setEmail("sid@cloudberry.services");
		lp.setPwd("Test123");
		lp.clickLogin();

		CheckoutPage checkoutPage = new CheckoutPage(getDriver());

		// Complete checkout process
		checkoutPage.completeCheckout();

		// Validate order confirmation
		ConfirmationPage confp = new ConfirmationPage(getDriver());
		Assert.assertTrue(confp.verifyOrderConfirmation());
		// Assert.assertTrue(confp.verifyOrderConfirmation(), "Order was not placed
		// successfully!");
	}
}