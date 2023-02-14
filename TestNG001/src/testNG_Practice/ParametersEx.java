package testNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersEx {
	
  public WebDriver driver;
	
  @Test
  @Parameters({"username" , "password"})
  public void login4(String username, String password) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();	
	  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	  System.out.println("Sign In with invalid credentials-1");
	  driver.findElement(By.linkText("Sign In")).click();  
	  Thread.sleep(3000);
	  driver.findElement(By.name("username")).sendKeys("Mohini");
	  driver.findElement(By.name("password")).sendKeys("Mohini@123");
	  driver.findElement(By.name("signon")).click();  
	  driver.close();
  }
  
  @Test
  @Parameters({"username" , "password"})
  public void login1(String username, String password) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	  System.out.println("Sign In with invalid credentials-2");
	  driver.findElement(By.linkText("Sign In")).click();  
	  Thread.sleep(3000);
	  driver.findElement(By.name("username")).sendKeys("2345678");
	  driver.findElement(By.name("password")).sendKeys("123456");
	  driver.findElement(By.name("signon")).click();
	  
	  driver.close();
  }
  
  @Test
  @Parameters({"username" , "password"})
  public void login2(String username, String password) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();	
	  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	  System.out.println("Sign In with invalid credentials-3");
	  driver.findElement(By.linkText("Sign In")).click(); 
	  Thread.sleep(3000);
	  driver.findElement(By.name("username")).sendKeys("Mohini@123");
	  driver.findElement(By.name("password")).sendKeys("Mohini@123");
	  driver.findElement(By.name("signon")).click();
	  driver.close();
  }
  
  @Test
  @Parameters({"username" , "password"})
  public void login3(String username, String password) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\MKENDRE\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();	
	  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	  System.out.println("Sign In with invalid credentials-4");
	  driver.findElement(By.linkText("Sign In")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.name("username")).sendKeys("  ");
	  driver.findElement(By.name("password")).sendKeys("  ");
	  driver.findElement(By.name("signon")).click();
	  driver.close();
  } 
}
