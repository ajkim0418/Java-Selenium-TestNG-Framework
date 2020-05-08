package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.BasePage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BasePage{

	@Test(priority=0)
	public void navigateToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverOverHeadsetsTab();
		logger.log(LogStatus.INFO, "Hovering over 'Headsets'");
		homePage.clickOculusQuest();
		logger.log(LogStatus.INFO, "Selecting Oculus Quest link");
		homePage.addToCart();
		logger.log(LogStatus.INFO, "Adding item to cart");
		Assert.assertTrue(homePage.isCartPageLoaded());
	}

	@Test(priority=1)
	public void verifyRemovingFromCart() {
		CartPage cartsPage = new CartPage(driver);
		cartsPage.removeItemFromCart();
		logger.log(LogStatus.INFO, "Removing item from cart");
		Assert.assertTrue(cartsPage.isItemRemoved());
	}

	@Test(priority=2, dependsOnMethods="verifyRemovingFromCart")
	public void verifyReadingItemToCart() {
		CartPage cartsPage = new CartPage(driver);
		cartsPage.addItemToCartAgain();
		logger.log(LogStatus.INFO, "Readding an item to cart");
		Assert.assertTrue(cartsPage.isItemAdded());
	}

	@Test(priority=3)
	public void selectAShippingCountry() {
		CartPage cartsPage = new CartPage(driver);
		cartsPage.selectCountry("CA");
		logger.log(LogStatus.INFO, "Changing shipping country to value CA");
		Assert.assertEquals(cartsPage.selectedCountry(), "Canada");
	}

	@Test(priority=4)
	public void verifyClickingCheckoutLoadsCheckoutPage() {
		CartPage cartsPage = new CartPage(driver);
		cartsPage.clickCheckoutButton();
		logger.log(LogStatus.INFO, "Clicking checkout button");
		Assert.assertTrue(cartsPage.isCheckoutPageLoaded());
	}

	@Test(priority=5, dependsOnMethods="verifyClickingCheckoutLoadsCheckoutPage")
	public void enterPersonalDetails() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.enterFirstName("Name");
		logger.log(LogStatus.INFO, "Entering first name in the First Name field");
		checkoutPage.enterLastName("Last Name");
		logger.log(LogStatus.INFO, "Entering last name in the Last Name field");
		checkoutPage.enterPhoneNumber("123412341");
		logger.log(LogStatus.INFO, "Entering phone number in the Phone field");
		checkoutPage.enterAddress("1234 Address St");
		logger.log(LogStatus.INFO, "Entering address in the Address field");
		checkoutPage.enterCity("Highlands");
		logger.log(LogStatus.INFO, "Entering city in the City field");
		checkoutPage.selectState("BC");
		logger.log(LogStatus.INFO, "Selecting from state/province from dropdown");
		checkoutPage.enterZipcode("V9B 0K7");
		logger.log(LogStatus.INFO, "Entering zip code in the Zip Code field");
		checkoutPage.enterEmail("test@yahoo.com");
		logger.log(LogStatus.INFO, "Entering email in the Email field");
		try {
			Assert.assertTrue(checkoutPage.isContinueButtonEnabled());
			logger.log(LogStatus.PASS, "Continue button is enabled, all data are correct");
		} catch(Exception e) {
			logger.log(LogStatus.WARNING, "Continue button was not enabled due to invalid data");
		}
	}
}
