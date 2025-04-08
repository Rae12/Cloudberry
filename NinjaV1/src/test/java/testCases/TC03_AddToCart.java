package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddToCartPage;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC03_AddToCart extends BaseClass {

	@Test
	public void testAddAnItemToWishList() {

		// Navigate and select product
		HomePage hp = new HomePage(driver);
		hp.navigateToLaptopsAndNotebooks();
		CategoryPage cp = new CategoryPage(driver);
		cp.selectProduct();
		AddToCartPage atcp = new AddToCartPage(driver);

		// Set delivery date and add to cart
		atcp.setDeliveryDate();
		atcp.clickAddToCart();

		// Validate success message
		Assert.assertTrue(atcp.verifySuccessMessage());
		// Assert.assertTrue(addToCartPage.verifySuccessMessage(), "Product was not
		// added successfully!");
	}
}