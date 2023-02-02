package jUnit;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class JUnitTask {
	static WebDriver driver;
	static WebElement element;
	
	@BeforeClass
	public static void beforeClassMethod() {
		System.out.println("Before class method completed");	
	}
	
	@Before
	public void beforeMethod() {
		System.out.println("This is inside beforeMethod");
	}
	
	@Test
	public void validUserCredentials(){ //To test successful login
	System.getProperty("webdriver.chorome.driver","C:/Users/MKENDRE/Downloads/chromedriver_win32 (1)/chromedriver");
	WebDriver driver = new ChromeDriver();
	//System.out.println("This is the test code " + new Object(){}.getClass().getEnclosingMethod().getName());
	driver.navigate().to("https://demoqa.com/books");
	driver.manage().window().maximize();
	driver.findElement(By.id("login")).click();
	driver.findElement(By.id("userName")).sendKeys("Mohini"); //Sending valid UserName	
	driver.findElement(By.id("password")).sendKeys("Mohini@123"); // Sending invalid Password	
	driver.findElement(By.id("login")).click();
	System.out.println("Test 1 Completed");
	}
	
	@Test
	public void inValidUserCredentials(){ //To test login with in valid user name and password
	System.getProperty("webdriver.chorome.driver","C:/Users/MKENDRE/Downloads/chromedriver_win32 (1)/chromedriver");
	WebDriver driver = new ChromeDriver();
	//System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	driver.navigate().to("https://demoqa.com/books");
	driver.findElement(By.id("login")).click();
	driver.findElement(By.id("userName")).sendKeys("1234@56"); //Sending UserName
	driver.findElement(By.id("password")).sendKeys("123456"); // Sending Password
	driver.findElement(By.id("login")).click();
	System.out.println("Test 2 completed");
	driver.close();
	}
	
	@After
	public void afterMethod() {
		System.out.println("This is inside afterMethod");	
	}
	
	@AfterClass
	public static void afterClassMethod() {
		System.out.println("After class method completed");
	}
}
