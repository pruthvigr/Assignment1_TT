package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FlipkartItemObjects {
	private WebDriver driver;
	By priceInItemPage=By.cssSelector("div[class='_30jeq3 _16Jk6d']");
	By orginalpriceInItemPage=By.cssSelector("div[class='_3I9_wc _2p6lqe']");
	By pincode=By.id("pincodeInputId");
	By toCart=By.cssSelector("button[class='_2KpZ6l _2U9uOA _3v1-ww']");

	public FlipkartItemObjects(WebDriver driver) {

		this.driver=driver;
	}

	public double getItempricePage() {
		return Double.parseDouble(driver.findElement(priceInItemPage).getText().substring(1).replace(",", ""));
	}
	public String orginalItempricePage() {
		return driver.findElement(orginalpriceInItemPage).getText().substring(1);
	}

	public void enterPincode(String pin) {
		driver.findElement(pincode).sendKeys(pin);
		driver.findElement(pincode).sendKeys(Keys.ENTER);
	}
	public void addToCart() {
		driver.findElement(toCart).click();
	}


}
