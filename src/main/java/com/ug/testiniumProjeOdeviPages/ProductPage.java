package com.ug.testiniumProjeOdeviPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
			this.driver=driver;
		}

	@FindBy(how=How.ID,using="add-to-basket")
	@CacheLookup WebElement addToCartButton;

	public void addToCart() {
		try {
			Thread.sleep(2000);
			addToCartButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scrollDown() {
		try {
			Thread.sleep(1000);
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getPriceOnPage() {
		
		String price="0";
		String className="";
		
		try {
			Thread.sleep(2000);
			WebElement firstPriceOnPage = driver.findElement(By.xpath("//*[@id=\"sp-price-highPrice\"]"));
			WebElement priceOnPage = driver.findElement(By.xpath("//*[@id=\"sp-price-lowPrice\"]"));
			className = priceOnPage.getAttribute("class");
			if(className.equals("lowPrice                                                            lastPrice")){
				price=priceOnPage.getText();
				}
			else {
				
				price=firstPriceOnPage.getText();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return price;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/a")
	@CacheLookup WebElement goToCartButton;
	
	public String goToCart() {
		
		String price="0";
		
		try {
			Thread.sleep(1000);
			goToCartButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return price;
	}
	

}
