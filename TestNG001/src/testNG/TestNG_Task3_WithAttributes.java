package testNG;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TestNG_Task3_WithAttributes {
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
	  
	  @Test(groups = {"Return To Home Page"})
	  public void test1() {
		  System.out.println("Test Case 1 start");
		  driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("Fish");
		  driver.findElement(By.xpath("//input[@name='searchProducts']")).click();
		  driver.findElement(By.linkText("Return to Main Menu")).click();
		  System.out.println("Test Case 1 End");
	  }
	  
	  //It is a string @Test annotation that describes information about the test.
	  @Test (description = "this is Test-case Two.")
	  public void test2() {
		  System.out.println("Test Case 2 start");
		  driver.findElement(By.xpath("//img[@src='../images/reptiles_icon.gif']")).click();
		  driver.findElement(By.linkText("RP-SN-01")).click();
		  driver.findElement(By.linkText("Add to Cart")).click();
		  driver.findElement(By.linkText("Proceed to Checkout")).click();
		  System.out.println("Test Case 2 End");
	  }
	  
	  //When second test method is dependent on the first test method then use "dependOnMethods" attribute. 
	  //If the first test method fails the second test method will not run.
	  @Test(dependsOnMethods= {"test2"}) 
	  public void test3() {
		  System.out.println("Test Case 3 start");
		  driver.findElement(By.xpath("//img[@src='../images/logo-topbar.gif']")).click();
		  System.out.println("Test Case 3 End");
	  }

	  //IF the priority is lowest test case will run first and the highest priority test case will be executed last
	  @Test(priority=4)
	  public void fourthTest() {
		  System.out.println("Test Case 4 start");
		  driver.findElement(By.linkText("Sign In")).click();
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mohini");
		  driver.findElement(By.xpath("//input[@name ='password']")).sendKeys("Mohini@123");
		  driver.findElement(By.name("signon")).click();
		  System.out.println("Test Case 4 End");
	  }
	  
	  //It returns boolean value By default its value is true.
	  //If you want to skip some test method, then you need to explicitly specify 'false' value.
	  @Test(enabled = false)
	  public void test5() {
		  System.out.println("Test Case 5 start");
		  driver.findElement(By.xpath("//img[@name ='img_cart']")).click();
		  System.out.println("skipped Test case");
		  System.out.println("Test Case 5 End");
	  }
	  
	  //The 'groups' attribute is used to group the different test cases that belong to the same functionality.
	  @Test(groups = {"Return To Home Page"})
	  public void test6() {
		  System.out.println("Test Case 6 start");
		  driver.findElement(By.xpath("//img[@src='../images/logo-topbar.gif']")).click();
		  System.out.println("Test Case 6 End");  
	  }
	  
	  @AfterMethod
	  public void afterMethod() throws IOException, InterruptedException {
		  Thread.sleep( 2000);
		  File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  Files.copy(file,new File("C:\\Users\\MKENDRE\\eclipse-workspace\\TestNG001\\src\\ScreenShots" + "\\SS1" + ".jpg"));
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
		  Files.copy(file,new File("C:\\Users\\MKENDRE\\eclipse-workspace\\TestNG001\\src\\ScreenShots" + "\\SS2" + ".jpg"));
		  System.out.println("ScreenShot Stored in Folder name ScreenShots");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Closing Browser");
		  driver.close();
	  }
}
