package jUnit;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import junit.framework.Assert;

public class JunitTest_Task {
	static WebDriver driver;
	static WebElement element;
	
	@BeforeClass
	public static void beforeClassMethod() {
		System.out.println("Before class method completed");	
	}
	
	@Test
	public void validUserCredentials(){ //To test successful login
		
	ExtentHtmlReporter report = new ExtentHtmlReporter("Test1_ExtentReport.html");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(report);
	ExtentTest test1 = extent.createTest("DemoQA Login test: 1", "this test is to validate DemoQA Login functionalities with valid Uname and pass.");
	test1.log(Status.INFO, "Starting Test Cases 1");
	
	System.getProperty("webdriver.chorome.driver","C:/Users/MKENDRE/Downloads/chromedriver_win32 (1)/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.navigate().to("https://demoqa.com/books");
	driver.manage().window().maximize();
	
	driver.findElement(By.id("login")).click();
	test1.pass("Click on login button");
	
	driver.findElement(By.id("userName")).sendKeys("Mohini"); //Sending valid UserName
	test1.pass("Sending UserName");
	
	driver.findElement(By.id("password")).sendKeys("Mohini@123"); // Sending invalid Password
	test1.pass("Sending Password");
	
	driver.findElement(By.id("login")).click();
	test1.pass("Click on Login Button");

	test1.info("Test1 completed");
	
	System.out.println("Test 1 Completed");
	driver.close();
	extent.flush();
	}
	
	@Before
	public void beforeMethod() {
		System.out.println("This is inside Before ");
	}
	
	@Test
	public void inValidUserCredentials(){ //To test login with in valid user name and password
		ExtentHtmlReporter report = new ExtentHtmlReporter("Test2_ExtentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		ExtentTest test2 = extent.createTest("DemoQA Login test: 1", "this test is to validate DemoQA Login functionalities with In Valid UName and Pass");
		test2.log(Status.INFO, "Starting Test Cases 2");
		
		System.getProperty("webdriver.chorome.driver","C:/Users/MKENDRE/Downloads/chromedriver_win32 (1)/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://demoqa.com/books");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("login")).click();
		test2.pass("Click on login button");
		
		driver.findElement(By.id("userName")).sendKeys("1234@56"); //Sending UserName
		test2.pass("Sending Invalid UserName");
		
		driver.findElement(By.id("password")).sendKeys("123456"); // Sending Password
		test2.pass("Sending Invalid Password");
		
		driver.findElement(By.id("login")).click();
		test2.pass("Click on login button");
		
		driver.getPageSource();
		WebElement errortext = driver.findElement(By.id("name"));
		String error = errortext.getText();
		String errorMsg = "Invalid username or password!";
		Assert.assertEquals(error,errorMsg);
		driver.close();
		/*if(error == errorMsg) {
			test2.pass("Getting Error Msg");
		}else {
			test2.fail("Do Not Find AnyError msg.");
		}*/
		
		driver.close();
		test2.info("Test2 completed");
		System.out.println("Test 2 Completed");
		extent.flush();
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
