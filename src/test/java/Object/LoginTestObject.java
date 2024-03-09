package Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginTestObject {
	@FindBy(id="uid")
	@CacheLookup
	public static WebElement Username;
	
	@FindBy(id="pwd")
	@CacheLookup
	public static WebElement Password;
	
	@FindBy(id="submit")
	@CacheLookup
	public static WebElement SubmitButton;

}
