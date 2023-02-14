package testNG;
 
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_ParametersTask {
	@Test
	@Parameters("myName")
	public void testParameter(String myName) {
		System.out.println("Parameters value is :" + myName);
	}	
}
