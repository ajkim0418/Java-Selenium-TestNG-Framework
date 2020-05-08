package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForumsPage {
	
	By forumsHeader = By.cssSelector(".c_Header-logoLink");
	By paginationBar = By.cssSelector("#PagerBefore");
	By numberedPages = By.tagName("a");
	By newResults = By.cssSelector(".DataList.Discussions");
	By forumsSearchBar = By.cssSelector("#Form_Search");
	By forumsSearchResults = By.cssSelector("#search-results");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ForumsPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}

	public boolean isForumsHeaderPresent() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forumsHeader));
		return driver.findElement(forumsHeader).isDisplayed();
	}
	
	public List<WebElement> getPagination(){
		return driver.findElement(paginationBar).findElements(numberedPages);
	}

	public boolean isNextPageSuccessful() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(newResults));
		return driver.findElement(newResults).isDisplayed();
	}
	
	public void searchForum(String text) {
		driver.findElement(forumsSearchBar).sendKeys(text);
	}
	
	public void pressEnter() {
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}
	
	public boolean isSearchSuccessful() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forumsSearchResults));
		return driver.findElement(forumsSearchResults).isDisplayed();
	}
}
