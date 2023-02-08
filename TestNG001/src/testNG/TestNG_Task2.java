package testNG;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Task2 {
	public WebDriver driver;
 
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Launching Browser");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Maximize Window");
  	  driver.manage().window().maximize();
  	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Navigating Towords JpetStore Demo Automation Testing Application");
  	  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
  }
  
  @BeforeMethod
  public void beforeMethod() { 
	  System.out.println("Validate Title");
	  String title =  driver.getTitle();
      System.out.println(title);
      String actual = "JPetStore Demo";
      String expected = "JPetStore Demo";
      Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void test1() {
	  System.out.println("Test Case 1 start");
	  driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("Fish");
	  driver.findElement(By.xpath("//input[@name='searchProducts']")).click();
	  driver.findElement(By.linkText("Return to Main Menu")).click();
	  System.out.println("Test Case 1 End");
  }
  
  @Test
  public void test2() {
	  System.out.println("Test Case 2 start");
	  driver.findElement(By.xpath("//img[@src='../images/reptiles_icon.gif']")).click();
	  driver.findElement(By.linkText("RP-SN-01")).click();
	  driver.findElement(By.linkText("Add to Cart")).click();
	  driver.findElement(By.linkText("Proceed to Checkout")).click();
	  driver.findElement(By.linkText("Register Now!")).click();
	  driver.findElement(By.xpath("//input[@name='searchProducts']")).click();
	  System.out.println("Test Case 2 End");
	  
  }
  @Test
  public void test3() {
	  System.out.println("Test Case 3 start");
	  driver.findElement(By.linkText("Sign In")).click();
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mohini");
	  driver.findElement(By.xpath("//input[@name ='password']")).sendKeys("Mohini@123");
	  driver.findElement(By.name("signon")).click();
	  driver.findElement(By.xpath("//img[@src='../images/logo-topbar.gif']")).click();
	  System.out.println("Test Case 3 End");  
  }

  @AfterMethod
  public void afterMethod() throws IOException, InterruptedException {
	  Thread.sleep( 2000);
	  File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  Files.copy(file,new File("C:\\Users\\MKENDRE\\eclipse-workspace\\TestNG001\\src\\ScreenShots" + "\\FirstSS" + ".jpg"));
	  System.out.println("ScreenShot Stored in Folder");
  }

  @AfterClass
  public void afterClass() {
	  driver.findElement(By.xpath("//input[@name='keyword']")).clear();
	  driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("cat");
	  driver.findElement(By.xpath("//input[@name='searchProducts']")).click();
  }

  @AfterTest
  public void afterTest() throws InterruptedException, IOException {
	  Thread.sleep( 2000);
	  File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  Files.copy(file,new File("C:\\Users\\MKENDRE\\eclipse-workspace\\TestNG001\\src\\ScreenShots" + "\\SecondSS" + ".jpg"));
	  System.out.println("ScreenShot Stored in Folder");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Closing Browser");
	  driver.close();
  }

}
