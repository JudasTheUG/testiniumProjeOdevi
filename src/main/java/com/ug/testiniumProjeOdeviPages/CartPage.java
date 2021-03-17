package com.ug.testiniumProjeOdeviPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

WebDriver driver;
	
	public CartPage(WebDriver driver) {
			this.driver=driver;
		}
	
	
public String getPriceOnCart() {
		
		String price="0";
		
		try {
			Thread.sleep(1000);
			WebElement priceOnCart = driver.findElement(By.xpath("//*[@id=\"cart-price-container\"]/div[3]/p"));
			price=priceOnCart.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return price;
	}


public String increaseProductCount() {
	String itemCount="1";
	try {
		Thread.sleep(1000);
		WebElement count = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div[4]/div/div[2]/select"));
		count.click();
		WebElement option = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div[4]/div/div[2]/select/option[2]"));
		option.click();
		Thread.sleep(1000);
		itemCount = count.getAttribute("value");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return itemCount;
	
	
}


public void clearCart() {
	try {
		Thread.sleep(1000);
		WebElement deleteButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[6]/div[2]/div[2]/div[3]/div/div[2]/div/a"));
		deleteButton.click();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


public String getClassName() {
	
	String emptyOrNot="";
	
	try {
		Thread.sleep(1000);
		WebElement cartClass = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div[2]/div[1]"));
		emptyOrNot = cartClass.getAttribute("class");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return emptyOrNot;
}
	
}
