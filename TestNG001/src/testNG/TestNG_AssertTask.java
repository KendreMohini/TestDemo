package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_AssertTask {
	 
	public WebDriver driver;
	//It reduces time and Allows multi-threaded tests
	
	@Test(description = "Inside method test1()")
	   public void test1() {
	      System.out.println("Launching Browser");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		  String actual = "JPetStore Demo";
		  String expected = "JPetStore Demo";
		  Assert.assertEquals(actual, expected);
		  System.out.println(driver.getTitle());
	      driver.close();
	     	}
	
	@Test()
	public void test2() {
	      System.out.println("Inside method test2()");
	      System.out.println("Launching Browser");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://www.saucedemo.com/");
		  String actual = "Swag Labs";
		  String expected = "Swag Labs";
		 // Assert.assertEquals(actual, expected, "Swag Labs");
		  Assert.assertEquals(actual, expected, "Swag Labs");
		  System.out.println(driver.getTitle());
	      driver.close();
	   }
}
