package Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RewardSearchObject {
	
	@FindBy(xpath="//a[contains(text(),'Configuration Manager')]")
	@CacheLookup
	public static WebElement ConfigurationManagerButton;
	
	
	@FindBy(xpath="(//a[contains(text(),'Rewards')])[1]")
	@CacheLookup
	public static WebElement RewardsButton;
	
	@FindBy(id="Search_Rewards_search1_val")
	@CacheLookup
	public static WebElement RewardNameIDInputField;
	
	@FindBy(id="search1")
	@CacheLookup
	public static WebElement RewardNameSelect;
	
	@FindBy(id="rwd_type")
	@CacheLookup
	public static WebElement RewardTypeSelect;
	
	@FindBy(xpath="//span[@id=\"Search_Rewards_search\"]/span/button")
	@CacheLookup
	public static WebElement SearchButtonClick;
	
	@FindBy(xpath="(//tr[@id=\"yui-dt0-bdrow1\"]/td)[2]")
	@CacheLookup
	public static WebElement FirstRowResults;
	
	

}
