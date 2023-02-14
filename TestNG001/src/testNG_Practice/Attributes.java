package testNG_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Attributes {
	public WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();			
	}
	
	@Test(description = "It is description about test case")
	public void A1Description() {
		System.out.println("this is description attributes");
	}
	
	@Test(groups = {"Navigate to homepage"})
	public void A2Group() {
		System.out.println("this is group1 attributes");
	}
	
	@Test(enabled = false)
	public void A3Enabled() {
		System.out.println("this is enabled attributes");
	}
	
	@Test(timeOut = 200)
	public void A4TimeOut() {
		System.out.println("this is timeOut attributes");
	}
	
	@Test(priority = 1)
	public void A5Priority() {
		System.out.println("this is priority attributes");
	}
	
	@Test
	public void A6dependsOnM1() {
		System.out.println("this is dependsOnMethod 1 attributes");
	}
	
	@Test(dependsOnMethods = {"A6dependsOnM1"})
	public void A6dependsOnM2() {
		System.out.println("this is dependsOnMethod 2 attributes");
	}
	
	@Test(groups = {"Navigate to homepage"})
	public void A7Group2() {
		System.out.println("this is group2 attributes");
	}
	
	@AfterSuite
	public void closeB() {
		driver.close();
	}
}
