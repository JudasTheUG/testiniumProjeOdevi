package com.ug.testiniumProjeOdeviFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverProducer {
	public static WebDriver driver;
	
	public DriverProducer() {
		
	}
	
	public static WebDriver getDriver() {
		if(driver==null) {
			//Ýf below code doesn't work on your compute change the version of chrome browser to yours.
			WebDriverManager.chromedriver().browserVersion("89.0.4389.90").setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\path\\my\\chromedriver.exe") can be used instead of line 20
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("start-maximized");
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options); 
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		
		return driver;
	}
}
