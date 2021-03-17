package com.ug.testiniumProjeOdeviPages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	


	public String getCurrentUrl() {
		
		if(driver.getCurrentUrl().equals("data:,")){
			return getCurrentUrl();
		}else {
			return driver.getCurrentUrl();
		}
		 
	}

}
