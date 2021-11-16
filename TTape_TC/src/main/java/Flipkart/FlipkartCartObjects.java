package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartCartObjects {
	private WebDriver driver;
	By increaseItem=By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/button[2]");
	By priceInCartPage=By.cssSelector("span[class='_2-ut7f _1WpvJ7']");
	

	public FlipkartCartObjects(WebDriver driver) {

		this.driver=driver;
	}
	public void increaseQuantity(int i) {
		for(int j=0;j<i;j++) {
		driver.findElement(increaseItem).click();
		}
	}
	public String getPriceAdd() {
		return driver.findElement(priceInCartPage).getText().substring(1);
	}
	
	
}
