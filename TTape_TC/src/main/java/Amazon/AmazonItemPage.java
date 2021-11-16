package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AmazonItemPage {
	private WebDriver driver;
	By amazonItemPrize=By.cssSelector("span[id='priceblock_ourprice']");
	By addCart=By.id("add-to-cart-button");
	//By addSideCart=By.id("attach-sidesheet-view-cart-button");
	public AmazonItemPage(WebDriver driver) {

		this.driver=driver;
	}
	
	public double getItemprice() {
		//driver.findElement(amazonItemPrize).click();
		return Double.parseDouble((driver.findElement(amazonItemPrize).getText().substring(1)).replace(",", ""));
	}
	public void clickOnAddCart() {
		driver.findElement(addCart).click();
				//if(driver.findElement(addSideCart)!=null) {
			//driver.findElement(addSideCart).click();			
		//}
		
	}
	

}
