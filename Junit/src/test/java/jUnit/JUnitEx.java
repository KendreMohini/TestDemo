package jUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class JUnitEx {
	 @Test //The method Testcase1 annotated with @Test is the testCase in the class.
	 public void testAnnotation() {
		 System.out.println("'@Test' : 1 annotation");
	 }
	 
	 @Before //The method annotated with @Before executes before TestCase 1 begins.
	 public void beforeAnnotation() {
		 System.out.println("'@Before' : 2 annotation");
	 }
	 
	 @After //The method annotated with @After runs after TestCase 1 completes execution.
	 public void afterAnnotation() {
		 System.out.println("'@After' : 3 annotation");
	 }
	 
	 @BeforeClass //The method annotated with @BeforeClass is executed once at the start of the class.
	 public static void beforeTestAnnotation() {
		 System.out.println("'@BeforeClass' : 4 annotation");
	 }
	 
	 @AfterClass //The method annotated with @AfterClass is executed once at the end of the class after both testCase 1 and 2 are executed.
	 public static void afterClassAnnotation() {
		 System.out.println("' @AfterClass' : 5 annotation");
	 }
	 
	 @BeforeAll //JUnit 5 Annotation
	 public static void beforeAllAnnotation() {
		 System.out.println("'@BeforeAll' : 6 annotation");
	 }
	 
	 @AfterAll //JUnit 5 Annotation
	 public void afterAllAnnotation() {
		 System.out.println("'@AfterAll' : 7 annotation");
	 }
	 
	 @BeforeEach //JUnit 5 Annotation
	 public static void beforeEachAnnotation() {
		 System.out.println("' @AfterClass' : 8 annotation");
	 }
	 
	 @AfterEach //JUnit 5 Annotation
	 public void afterEachAnnotation() {
		 System.out.println("'@AfterClass' : 9 annotation");
	 }
	 
}
