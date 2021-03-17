package com.ug.testiniumProjeOdeviTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import com.ug.testiniumProjeOdeviPages.LoginPage;
import com.ug.testiniumProjeOdeviPages.MainPage;
import com.ug.testiniumProjeOdeviPages.ProductPage;
import com.ug.testiniumProjeOdeviPages.SearchResultPage;
import com.ug.testiniumProjeOdeviPages.SecondPageOfSearchResultPage;
import com.ug.testiniumProjeOdeviPages.CartPage;
import com.ug.testiniumProjeOdeviPages.HomePage;

public class testClass extends MiddleMan {

	public testClass() {
	
	}
	Logger log = Logger.getLogger(testClass.class);
	
	@Test //IsHomePage
	public void test1() {
		log.info("Testing Commences");
	
	try {
		driver.get("https://www.gittigidiyor.com/");
		HomePage mainPage = PageFactory.initElements(driver,HomePage.class);
		String currentUrl = mainPage.getCurrentUrl();
		assertEquals("https://www.gittigidiyor.com/",currentUrl);
		
	} catch(Exception e) {e.printStackTrace();}
	
	}
	
	@Test //isLoggedIn
	public void test2() {
	
	try {
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.goToLoginPage();
		loginPage.loginWordPress("z0o5ksq3qs@just4fun.me","denemetest123");		
		Map<String, String> cookies = loginPage.getBrowserCookies();
		assertNotEquals(cookies.get("_perm[SMS]"), null);
		
	} catch(Exception e) {e.printStackTrace();}
	
	}
	
	
	
	@Test //didSecondPageOpen
	public void test3() {
	
	try {
		MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
		mainPage.searchItem("bilgisayar");
		SearchResultPage resultPage = PageFactory.initElements(driver,SearchResultPage.class);
		resultPage.scrollDown();
		resultPage.goToSecondPage();
		SecondPageOfSearchResultPage secondResultPage = PageFactory.initElements(driver,SecondPageOfSearchResultPage.class);
		String currentUrl = secondResultPage.getCurrentUrl();
		assertEquals("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2",currentUrl);
		
	} catch(Exception e) {e.printStackTrace();}
	
	}
	
	@Test //arePricesSame
	public void test4() {
	
	try {
		String priceOnPage="", priceOnCart="";
		SecondPageOfSearchResultPage secondResultPage = PageFactory.initElements(driver,SecondPageOfSearchResultPage.class);
		secondResultPage.chooseRandomProduct();
		ProductPage productPage = PageFactory.initElements(driver,ProductPage.class);
		priceOnPage=productPage.getPriceOnPage();
		productPage.scrollDown();
		productPage.addToCart();
		priceOnCart=productPage.goToCart();
		CartPage cartPage = PageFactory.initElements(driver,CartPage.class);
		priceOnCart=cartPage.getPriceOnCart();
		assertEquals(priceOnPage,priceOnCart);
		//TODO
	} catch(Exception e) {e.printStackTrace();}
	
	}
	
	@Test //isProductCountTwo
	public void test5() {
	
	try {
		String compareAmount = "0" ;
		CartPage cartPage = PageFactory.initElements(driver,CartPage.class);
		compareAmount = cartPage.increaseProductCount();
		assertEquals("2",compareAmount);
	} catch(Exception e) {e.printStackTrace();}
	
	}
	
	@Test //isCartEmpty
	public void test6() {
	
	try {
		String emptyCartClassName = "";
		CartPage cartPage = PageFactory.initElements(driver,CartPage.class);
		cartPage.clearCart();
		emptyCartClassName = cartPage.getClassName();
		assertEquals("clearfix",emptyCartClassName);
		log.info("Testing Ends");
	} catch(Exception e) {e.printStackTrace();}
	
	}
	
}
