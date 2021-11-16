package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCartPage {
	private WebDriver driver;
	//By amazonCartItemPrize=By.cssSelector("span[class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']");
	By amazonCartItemPrize=By.cssSelector("span[class='a-color-price hlb-price a-inline-block a-text-bold']");
	public AmazonCartPage(WebDriver driver) {

		this.driver=driver;
	
	}
	public Double amazonCartPrice() {
		return Double.parseDouble((driver.findElement(amazonCartItemPrize).getText().substring(1)).replace(",", ""));
	}	
public void cheaperPrice(double amazonItemPrice,double flipkartItemPrice) {
	if(amazonItemPrice<flipkartItemPrice) {
		System.out.println("Price of item is cheaper in amazon :"+amazonItemPrice);
	}
	else if(amazonItemPrice>flipkartItemPrice) {
		System.out.println("Price of item is cheaper in flipkart :"+flipkartItemPrice);
	}
	else {
		System.out.println("price is same in both :"+flipkartItemPrice);
	}
}
	
	
}
