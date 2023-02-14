package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersInTestNG {
	
  @Test(description = "This is Additioon")
  @Parameters({"Value1","Value2"})
  public void addn(double FValue, double SValue) {
	double  add = FValue+SValue;
	System.out.println("Addition is: " + add);
  }
  
  @Test(priority = 2)
  @Parameters({"Value1","Value2"})
  public void subn(double FValue, double SValue) {
	double  sub = FValue-SValue;
	System.out.println("Substraction is: " + sub);
  }
  
  @Test()
  @Parameters({"Value1","Value2"})
  public void muln(double FValue, double SValue) {
	double  mul = FValue*SValue;
	System.out.println("Multiplication is: " + mul);
  }
  
  @Test(timeOut = 100)
  @Parameters({"Value1","Value2"})
  public void divn(double FValue, double SValue) {
	double  div = FValue/SValue;
	System.out.println("Division is: " + div);
  }
  
  @Test(enabled = false)
  @Parameters({"Value1","Value2"})
  public void divn1(double FValue, double SValue) {
	double  div = FValue/SValue;
	System.out.println("Division is: " + div);
  }
  
  @Test(dependsOnMethods = {"divn" , "muln"})
  @Parameters({"Value1","Value2"})
  public void mod(double FValue, double SValue) {
	double  mod = FValue%SValue;
	System.out.println("Mod is: " + mod);
  }
}
