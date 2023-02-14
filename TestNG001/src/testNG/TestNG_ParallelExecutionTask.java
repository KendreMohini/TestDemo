package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG_ParallelExecutionTask {
	public WebDriver driver;
	//It reduces time and Allows multi-threaded tests
	@Test(description = "Inside method test1()")
	   public void test1() {
	      System.out.println("Launching Browser");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	      driver.findElement(By.linkText("Sign In")).click();
	      driver.findElement(By.name("username")).sendKeys("Mohini");
	      driver.findElement(By.name("password")).sendKeys("Mohini@123");
	      driver.findElement(By.name("signon")).click();
	      driver.close();
	     	}
	@Test(dependsOnMethods = {"test1"})
	public void test2() {
	      System.out.println("Inside method test2()");
	      System.out.println("Launching Browser");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://www.saucedemo.com/");
	      driver.findElement(By.name("user-name")).sendKeys("Mohini");
	      driver.findElement(By.name("password")).sendKeys("Mohini@123");
	      driver.findElement(By.id("login-button")).click();
	      driver.close();
	   }
}
