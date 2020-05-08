package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import pages.BasePage;
import pages.HomePage;

public class LoginPageTest extends BasePage{
	
	@Test(priority=0)
	public void navigateToLoginPage() {
		HomePage homePage = new HomePage(driver);
		homePage.clickLogInLink();
		logger.log(LogStatus.INFO, "Clicking 'Log In or Sign Up' button");
		homePage.clickSigninLink();
		logger.log(LogStatus.INFO, "Clicking the 'Sign in' link");
	}
	
	//* Test invalid login attempts using data from DataProvider
	@DataProvider(name="accounts")
	public Object[][] getData(){
		return new Object[][] {
			{"InvalidEmail@gmail.com", "testing123"}, // Invalid email, correct password
			{"testuser@yahoo.com", "InvalidPassword2"} // Correct email, Invalid password
		};
	}
	
	@Test(priority=1, dataProvider="accounts")
	public void verifyInvalidLoginCredentials(String testUsername, String testPassword) {
		LoginPage login = new LoginPage(driver);
		login.typeUsername(testUsername);
		logger.log(LogStatus.INFO, "Entering invalid username");
		login.typePassword(testPassword);
		logger.log(LogStatus.INFO, "Entering invalid password");
		login.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
		Assert.assertTrue(login.errorContainerDisplayed());
		logger.log(LogStatus.PASS, "Log in with invalid crendentials failed");
	}
	
	@Test(priority=2)
	@Parameters({"username", "password"})
	public void verifyLogin(String username, String password) { 
		LoginPage login = new LoginPage(driver);
		login.typeUsername(username);
		logger.log(LogStatus.INFO, "Entering valid username");
		login.typePassword(password);
		logger.log(LogStatus.INFO, "Entering valid password");
		login.clickSignIn();
		logger.log(LogStatus.INFO, "Clicking Sign in button");
		Assert.assertTrue(login.verifyNewPage());
	}
}	
