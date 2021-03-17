package com.ug.testiniumProjeOdeviPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPage {

WebDriver driver;
	
public SearchResultPage(WebDriver driver) {
		this.driver=driver;
	}

@FindBy(how=How.XPATH,using="//*[@id=\"best-match-right\"]/div[5]/ul/li[2]")
@CacheLookup WebElement secondPageButton;

public void goToSecondPage() {
	try {
		Thread.sleep(1000);
		secondPageButton.click();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void scrollDown() {
	try {
		Thread.sleep(2000);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)");
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
}
	
	
}
