package Flipkart_Testcases;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Amazon.AmazonCartPage;
import Amazon.AmazonHomePage;
import Amazon.AmazonItemPage;
import Common.SwitchWindow;
import Flipkart.FlipkartCartObjects;
import Flipkart.FlipkartHomeObjects;
import Flipkart.FlipkartItemObjects;

import java.util.concurrent.TimeUnit;
///import java.util.List;


//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;


public class FlipkartAmazonAddToCart {
	WebDriver driver;
	FlipkartHomeObjects flipartHomeObject;
	SwitchWindow switchTo;
	FlipkartItemObjects flipkartItemObject;
	FlipkartCartObjects flipkartCartObject;
	AmazonHomePage amazonHomeObject;
	AmazonItemPage amazonItemObject;
	AmazonCartPage amazonCartObject;
	static String flipkrtOrginalPrice;
	static double flipkartItemPrice;
	static double amazonItemPrice;

	@BeforeMethod
	public void launchDriver() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prithvi\\eclipse-workspace\\chromedriver.exe");  
		driver=new ChromeDriver();  
		flipartHomeObject=new FlipkartHomeObjects(driver);
		switchTo=new SwitchWindow(driver);
		flipkartItemObject=new FlipkartItemObjects(driver);
		flipkartCartObject=new FlipkartCartObjects(driver);
		amazonHomeObject=new AmazonHomePage(driver);
		amazonItemObject=new AmazonItemPage(driver);
		amazonCartObject=new AmazonCartPage(driver);
	}
	@AfterMethod
	public void closeDriver() throws InterruptedException{
		//driver.quit();

	}


	@Test (priority=1)
	public void flipkartAddToCart2() throws InterruptedException{

		//Launch URL

		driver.get("https://www.flipkart.com/"); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		flipartHomeObject.closePopUp();
		flipartHomeObject.searchItem("iphone 12");
		flipartHomeObject.selectItem();
		driver.manage().window().maximize();
		switchTo.switchToWindow(2);

		double flipkartPrice=flipkartItemObject.getItempricePage();
		System.out.println(flipkartPrice);
		flipkartItemObject.enterPincode("560037");		
		Thread.sleep(1000);
		flipkartItemObject.addToCart();
		Thread.sleep(1000);
		flipkartCartObject.increaseQuantity(1);
		Thread.sleep(1000);
		String priceAfterIncreaseInItem=flipkartCartObject.getPriceAdd();
		System.out.println(priceAfterIncreaseInItem);

	}


	@Test (priority=2)
	public void flipkartAddToCart() throws InterruptedException{

		//Launch URL
		driver.get("https://www.flipkart.com/"); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		flipartHomeObject.closePopUp();
		flipartHomeObject.searchItem("samsung 6kg front load washing machine WW60R20GLSS/TL");
		//flipartHomeObject.searchItem("one plus tv");
		flipartHomeObject.selectItem();
		driver.manage().window().maximize();
		switchTo.switchToWindow(2);
		flipkrtOrginalPrice=flipkartItemObject.orginalItempricePage();
		//System.out.println(flipkrtOrginalPrice);
		Thread.sleep(1000);
		flipkartItemPrice=flipkartItemObject.getItempricePage();
		System.out.println("Flipkart Item price before adding to cart:"+flipkartItemPrice);
		flipkartItemObject.enterPincode("560037");		
		Thread.sleep(1000);
		flipkartItemObject.addToCart();
		Thread.sleep(1000);
		String priceAfterAddingToCart=flipkartCartObject.getPriceAdd();
		System.out.println("Flipkart Item price after adding to cart:"+priceAfterAddingToCart);


	}
	@Test (priority=3)
	public void amazonAddToCart() throws InterruptedException{


		//Launch URL
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/"); 
		amazonHomeObject.searchItem("samsung 6kg front load washing machine WW60R20GLSS/TL");
		driver.manage().window().maximize();
		System.out.println(flipkrtOrginalPrice);
		Thread.sleep(2000);
		amazonHomeObject.selectMatchedItem(flipkrtOrginalPrice);
		Thread.sleep(2000);
		switchTo.switchToWindow(2);
		amazonItemPrice=amazonItemObject.getItemprice();
		//System.out.println("Item price in Amazon"+priceInItemPage);
		amazonItemObject.clickOnAddCart();
		Thread.sleep(1000);
		double amazonCartPrice=amazonCartObject.amazonCartPrice();
		System.out.println("Item price after adding to  cart:"+amazonCartPrice);
		amazonCartObject.cheaperPrice(amazonItemPrice, flipkartItemPrice);
	}
}
