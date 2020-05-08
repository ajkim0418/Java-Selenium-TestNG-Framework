package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage{

	@Test(priority=0)
	public void verifyTitle() {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking title matches string");
		Assert.assertEquals(homePage.getTitle(), "Oculus | VR Headsets & Equipment", "Title does not match");
		logger.log(LogStatus.PASS, "Title matches with title from DOM");
	}

	@Test(priority=1)
	public void verifyLogo() {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Checking if logo is present");
		Assert.assertTrue(homePage.getLogo());
		logger.log(LogStatus.PASS, "Logo is present");
	}

	@Test(priority=2)
	public void verifyHeadsetsDropdown() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverOverHeadsetsTab();
		logger.log(LogStatus.INFO, "Hovering over Headsets tab");
		for(int i=0; i<homePage.headsetsDropdownResults().size(); i++) {
			String displayedName = homePage.headsetsDropdownResults().get(i).getText();
			String[] expected = {
					"Oculus Rift S\n" + "PC-Powered VR Gaming", 
					"Oculus Quest\n" + "All-In-One VR Gaming", 
					"Oculus Go\n" + "All-In-One VR Viewing", 
			"Compare All Headsets"};
			logger.log(LogStatus.INFO, "Checking if " + displayedName + " link is present");
			Assert.assertEquals(expected[i], displayedName);
		}
	}
}
