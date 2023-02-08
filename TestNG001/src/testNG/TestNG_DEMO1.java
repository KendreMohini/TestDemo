package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_DEMO1 {
  @Test
  public void test() {
	  System.out.println("Executes Test-1 method 'test' ");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executes @BeforeMethod");
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Executes @AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Executes @BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Executes @AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Executes @BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Executes @AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Executes @BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Executes @AfterSuite");
  }

}
