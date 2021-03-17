package com.ug.testiniumProjeOdeviTest;

import org.junit.Before;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import com.ug.testiniumProjeOdeviFramework.DriverProducer;

public class MiddleMan {

	public static WebDriver driver;
	DriverProducer producer;
	
	public MiddleMan() {
		// TODO Auto-generated constructor stub
	}
	
	@Before
	public void beforeMethod() {
		MiddleMan.driver=DriverProducer.getDriver();
	}
	
	@AfterClass
	public static void afterSuite() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
}
