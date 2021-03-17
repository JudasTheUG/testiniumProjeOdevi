package com.ug.testiniumProjeOdeviPages;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	WebDriver driver;
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
}

@FindBy(how=How.XPATH,using="/html/body/div[1]/header/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]")
@CacheLookup WebElement drawerOpener;

public void goToLoginPage() {
	try {
		Actions action = new Actions(driver);
		action.moveToElement(drawerOpener).pause(4000).click().build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement goToLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[1]/div[2]/div/div/div/a")));
		action.moveToElement(goToLogin).click().build().perform();
		
		
	} catch (Exception e) {System.out.println(e);}
}

public void loginWordPress(String user, String pswrd) {
	try {
		
		WebElement userName = driver.findElement(By.id("L-UserNameField"));
		userName.sendKeys(user);
		Thread.sleep(1000);
		WebElement userPass = driver.findElement(By.id("L-PasswordField"));
		userPass.sendKeys(pswrd);
		Thread.sleep(1000);
		WebElement enterButton = driver.findElement(By.id("gg-login-enter"));
		enterButton.click();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
}


public Map<String, String> getBrowserCookies() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String cookiesString = (String) js.executeScript("return document.cookie");
	
    Map<String, String> cookies = new HashMap<>();

    if (StringUtils.isBlank(cookiesString)) {
        return cookies;
    }

    Arrays.asList(cookiesString.split("; ")).forEach(cookie -> {
        String[] splitCookie = cookie.split("=", 2);
        cookies.put(splitCookie[0], splitCookie[1]);
    });

    return cookies;
}


}
