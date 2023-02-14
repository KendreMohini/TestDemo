package test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import objects.Amazon_Search001;

public class Amazon_Seach_TC1 {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
	}
	
	@Test(description ="Search for Mobiles")
	//@Parameters({"value1", "value2"})
	public void searchForMobilePhones() {
		Amazon_Search001 amazonSearch = new Amazon_Search001(driver);
		amazonSearch.searchForMobile("Mobile");
		amazonSearch.clickOnSearchIcon();
		amazonSearch.clickOnAnyMobile();
		amazonSearch.fetchPriceOfMo();
	}
	
	@Test(dependsOnMethods = {"searchForMobilePhones"})
	public void screenShotOfDetails() throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy screenshot to desired location using copy file()
		Files.copy(file,new File("C:\\Users\\MKENDRE\\eclipse-workspace\\TestNGWithMaven_Amazon\\src\\test\\resources\\screenShots_Amazon_Search001" + "\\AmazonSearchSS" + ".jpg"));
		System.out.println("ScreenShot Stored in Folder");
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
