package com.qa.BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {

	public WebDriver driver;
	public SoftAssert softAssertion;
	public JavascriptExecutor js;


	@BeforeClass
	@Parameters({ "browser", "pageUrl"})
	public void Setup(String browser, String pageUrl) {
		switch (browser) {
		case "chrome": 
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\yamin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		    break; 
		case "edge": 
			System.setProperty("webdriver.edge.driver", "C:\\Users\\yamin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		    break; 
		
		case "firefox": 
			System.setProperty("webdriver.gecko.driver", "F:\\trainings\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		    break; 
	
		default: 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\yamin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
				    break; 

		}
		driver.manage().window().maximize();
		driver.get(pageUrl);
		js = (JavascriptExecutor) driver;

		softAssertion= new SoftAssert();
	}

	@AfterClass
	public void TearDown() {
		driver.close();
	}

}
