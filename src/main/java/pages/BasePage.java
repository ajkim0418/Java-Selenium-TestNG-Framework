package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {

	public static WebDriver driver;
	String url = "https://www.oculus.com/";
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeClass(alwaysRun=true)
	public void setup(ITestContext context) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
		System.setProperty("webdriver.chrome.driver", "/Users/Andy/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		context.setAttribute("WebDriver", driver);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
