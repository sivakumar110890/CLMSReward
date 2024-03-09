package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class commonFuntions {
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentHtmlReporter extent ;
	public static ExtentReports report;
	public static ExtentTest logger;
	

	public Properties LoadPropertyFile() throws IOException {
		FileInputStream fileinput = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
		prop = new Properties();
		prop.load(fileinput);
		return prop;
		
	}
	
	@BeforeSuite
	public void LaunchBrowser() throws IOException {
		LoadPropertyFile();
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//config//log4j.properties");
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		extent = new ExtentHtmlReporter("Extentreport.html");
		report=new ExtentReports();
		report.attachReporter(extent);
		
		
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers/chromedriver.exe");
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(opt);
		}
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		}
		
	
	
	@AfterSuite
	public void CloseBrowser() {
		//driver.quit();
		
	}
	
	
}
