package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	By firstNameField = By.name("firstName");
	By lastNameField = By.name("lastName");
	By phoneField = By.name("phoneNumber");
	By addressField = By.name("address1");
	By cityField = By.name("city");
	By stateProvinceDropdown = By.cssSelector("._296s._47p_");
	By zipcodeField = By.name("postalCode");
	By emailField = By.name("email");
	By emailOptInCheckbox = By.name("optInAsGuest");
	By continueToPaymentButton = By.name("submit");
	By errorContainer = By.xpath("//div[@class=' _64f3'][contains(text(), 'Please specify a valid email')]");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).clear();
		driver.findElement(firstNameField).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).clear();
		driver.findElement(lastNameField).sendKeys(lastName);
	}
	
	public void enterPhoneNumber(String phone) {
		driver.findElement(phoneField).clear();
		driver.findElement(phoneField).sendKeys(phone);
	}
	
	public void enterAddress(String address) {
		driver.findElement(addressField).clear();
		driver.findElement(addressField).sendKeys(address);
	}
	
	public void enterCity(String city) {
		driver.findElement(cityField).clear();
		driver.findElement(cityField).sendKeys(city);
	}
	
	public void selectState(String state) {
		new Select(driver.findElement(stateProvinceDropdown)).selectByValue(state);
	}
	
	public void enterZipcode(String zipcode) {
		driver.findElement(zipcodeField).clear();
		driver.findElement(zipcodeField).sendKeys(zipcode);
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public boolean isErrorContainerDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorContainer)).isDisplayed();
	} 
	
	public boolean isContinueButtonEnabled() {
		return wait.until(ExpectedConditions.elementToBeClickable(continueToPaymentButton)).isDisplayed();
	}
	
	
}
