package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCertificatePage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC06_GifftCertificcate extends BaseClass {

	@Test (groups = {"regression"})
	void testPurchaseAGiftCertificate() {
		HomePage hp = new HomePage(getDriver());
		hp.clickGiftCertificateLink();
		GiftCertificatePage gcp = new GiftCertificatePage(getDriver());

		gcp.enterRecipientDetails("John", "john@gmail.com");
		gcp.enterSenderDetails("Sid", "sid@cloudberry.services");
		gcp.selectGiftTheme();
		gcp.agreeToTerms();
		gcp.clickContinue();

		// Validate confirmation message
		Assert.assertTrue(gcp.isPurchaseSuccessMessageDisplayed());
		// Assert.assertTrue(gcp.isPurchaseSuccessMessageDisplayed(), "Gift Certificate
		// purchase failed!");
	}
}