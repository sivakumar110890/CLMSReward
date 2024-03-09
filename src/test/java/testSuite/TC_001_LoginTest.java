package testSuite;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Object.LoginTestObject;
import common.commonFuntions;

public class TC_001_LoginTest extends commonFuntions{
	
	public void LoginTest() {
		PageFactory.initElements(driver, LoginTestObject.class);
		LoginTestObject.Username.sendKeys(prop.getProperty("username"));
		LoginTestObject.Password.sendKeys(prop.getProperty("password"));
		LoginTestObject.SubmitButton.click();
	}
	
	@Test
	public void LoginTestExecution() {
		LoginTest();
	}

}
