package com.ug.testiniumProjeOdeviPages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondPageOfSearchResultPage {

	WebDriver driver;
	
	public SecondPageOfSearchResultPage(WebDriver driver) {
			this.driver=driver;
		}
	

	
	public void chooseRandomProduct() {
		try {
			Random rand = new Random();
			int upperbound = 48;
			int indexOfproduct = rand.nextInt(upperbound) + 1;
			WebElement randomProduct = driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[3]/div[2]/ul/li["+indexOfproduct+"]"));
			Thread.sleep(2000);
			randomProduct.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getCurrentUrl() {
		
		if(driver.getCurrentUrl().equals("https://www.gittigidiyor.com/arama/?k=bilgisayar")){
			return getCurrentUrl();
		}else {
			return driver.getCurrentUrl();
		}
	}
	
}
