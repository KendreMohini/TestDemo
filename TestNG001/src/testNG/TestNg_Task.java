package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg_Task {
    public WebDriver driver; 
    
    @BeforeSuite
    public void beforeSuite() {
    	System.out.println("Executes @BeforeSuite: Launching Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
    @BeforeTest
	public void beforeTest() {
    	System.out.println("Executes @BeforeTest");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  }
    
    @BeforeClass
	public void beforeClass() {
    	System.out.println("Executes @BeforeClass");
    	driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	  } 
    
    @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Executes @BeforeMethod");
		  String title =  driver.getTitle();
	      System.out.println(title);
	  }
    
	 @Test(priority=1)
	 public void test1() throws InterruptedException {
		System.out.println("Executes Test-1 method 'test1' ");
		 driver.findElement(By.linkText("Sign In")).click() ;
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("Register Now!")).click();
	 }
	
	 @Test(priority=2)
	 public void test2() {
		System.out.println("Executes Test-2 method 'test2' ");
		
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Executes @AfterMethod");
		  driver.findElement(By.xpath("//img[@src = '../images/logo-topbar.gif']")).click() ;
          System.out.println("Going back to the home page"); 
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Executes @AfterClass");
		  driver.close();
          System.out.println("closing Chrome browser"); 
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("Executes @AfterTest");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Executes @AfterSuite /n End Of Program");
	  }

	 
}
