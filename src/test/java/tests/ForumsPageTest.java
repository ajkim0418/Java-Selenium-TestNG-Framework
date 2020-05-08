package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.ForumsPage;
import pages.HomePage;

public class ForumsPageTest extends BasePage{
	
	@Test(priority=0)
	public void navigateToForumsPage() {
		HomePage homePage = new HomePage(driver);
		homePage.hoverOverCommunityTab();
		logger.log(LogStatus.INFO, "Hovering over 'Community'");
		homePage.clickOnForumsTab();
		logger.log(LogStatus.INFO, "Clicking 'Forums'");
		homePage.switchTabs();
		logger.log(LogStatus.WARNING, "Opening tab in a new browser, switching to active tab");
	}
	
	@Test(priority=1, dependsOnMethods="navigateToForumsPage")
	public void verifyForumsHeaderPresent() {
		ForumsPage forumsPage = new ForumsPage(driver);		
		logger.log(LogStatus.INFO, "Checking if Forums header is present in the page");
		Assert.assertTrue(forumsPage.isForumsHeaderPresent());
	}
	
	@Test(priority=2)
	public void clickNextPage() {
		ForumsPage forumsPage = new ForumsPage(driver);
		for(int i=1; i<forumsPage.getPagination().size(); i++) {
			forumsPage.getPagination().get(i).click();
			logger.log(LogStatus.INFO, "Testing pagination, clicking page " + i);
			if(i==6) {
				break;
			}
			Assert.assertTrue(forumsPage.isNextPageSuccessful());
		}
	}
	
	@Test(priority=3)
	public void verifyForumSearch() {
		ForumsPage forumsPage = new ForumsPage(driver);
		forumsPage.searchForum("error");
		logger.log(LogStatus.INFO, "Typing keyword in searchbar");
		forumsPage.pressEnter();
		logger.log(LogStatus.INFO, "Sending keys 'ENTER'");
		Assert.assertTrue(forumsPage.isSearchSuccessful());
	}
}
