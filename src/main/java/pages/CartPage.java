package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	By removeOption = By.xpath("//button[contains(text(), 'Remove')]");
	By emptyCartMessage = By.xpath("//div[@class='_1uv2']/h4[contains(text(), 'Your cart is empty.')]");
	By addProductToCart = By.xpath("//div[9]//div[1]//form[1]//button[1]");
	By productDetails = By.cssSelector("._4rzp");
	By shippingCountryDropdown = By.cssSelector("#shippingCountry");
	By checkoutButton = By.cssSelector("._4ju3._4pg_._3hmq._4phk");
	By checkoutHeader = By.xpath("//span[@class='_45mg'][contains(text(), 'Checkout')]");
	By checkoutPageContent = By.cssSelector("._33ng._663y.clearfix");

	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	public void removeItemFromCart() {
		driver.findElement(removeOption).click();
	}

	public boolean isItemRemoved() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)).isDisplayed();
	}

	public void addItemToCartAgain() {
		driver.findElement(addProductToCart).click();
	}

	public boolean isItemAdded() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productDetails)).isDisplayed();
	}

	public void selectCountry(String country) {
		new Select(driver.findElement(shippingCountryDropdown)).selectByValue(country);
		wait.until(ExpectedConditions.attributeToBe(shippingCountryDropdown, "value", country));
	}

	public String selectedCountry() {
		return new Select(driver.findElement(shippingCountryDropdown)).getFirstSelectedOption().getText();
	}

	public void clickCheckoutButton() {
		driver.findElement(checkoutButton).click();
	}

	public boolean isCheckoutPageLoaded() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPageContent));
		return driver.findElement(checkoutHeader).isDisplayed();
	}

}
