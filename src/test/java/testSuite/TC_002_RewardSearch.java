package testSuite;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Object.RewardSearchObject;
import common.commonFuntions;



public class TC_002_RewardSearch extends commonFuntions{
	
	@Test
	public void RewardSearch() throws IOException {
		
		logger=report.createTest("Reward Search Test");
		logger.info("==== Reward search Test case execution is started ====");
		PageFactory.initElements(driver, RewardSearchObject.class);
		RewardSearchObject.ConfigurationManagerButton.click();
		logger.info("==== ConfigurationManager Button is clicked ==========");
		RewardSearchObject.RewardsButton.click();
		logger.info("===== Reward Button is clicked =======================");
		RewardSearchObject.RewardNameIDInputField.sendKeys(prop.getProperty("RewardNameForSearch"));
		logger.info("===Reward Name was entered : " + prop.getProperty("RewardNameForSearch"));
		Select rewardNameIdSelect = new Select(RewardSearchObject.RewardNameSelect);
		rewardNameIdSelect.selectByVisibleText("Reward Name");

		RewardSearchObject.SearchButtonClick.click();
		logger.info("==== Search button is clicked =======================");
		String ActualRewardName=RewardSearchObject.FirstRowResults.getText();
		String ExpecctedRewardName= prop.getProperty("RewardNameForSearch");
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(ActualRewardName,ExpecctedRewardName);
		{
			logger.info("Expected Reward Name in results : "+ExpecctedRewardName +" \n"+"Actual Reward Name : "+ActualRewardName);

		}
		
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir")+"//screenshots//RewardSearchresults.png");
		FileHandler.copy(Source, Destination);
		
		logger.info("==== Screenshot has been taken ====");
		
		logger.info("==== Reward search Test case execution is completed ====");
		logger.pass("Reward Search test is success");
		extent.flush();
	}

}
