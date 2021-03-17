package com.ug.testiniumProjeOdeviPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

	
	
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.NAME,using="k")
	@CacheLookup WebElement searchbox;
	@FindBy(how=How.TAG_NAME,using="button")
	@CacheLookup WebElement searchButton;
	
	public void searchItem(String item) {
		
		try {
			Thread.sleep(2000);
			searchbox.sendKeys(item);
			Thread.sleep(2000);
			searchButton.click();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}
}
