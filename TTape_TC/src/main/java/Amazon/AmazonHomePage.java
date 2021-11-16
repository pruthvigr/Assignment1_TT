package Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonHomePage {
	private WebDriver driver;
	By amazonSearchbox=By.id("twotabsearchtextbox");
	By orginalPrice=By.cssSelector("span[aria-hidden='true']");
	By itemElement=By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a");
	public AmazonHomePage(WebDriver driver) {
		
		this.driver=driver;
	}
public void searchItem(String item) {
		
		driver.findElement(amazonSearchbox).sendKeys(item);
		driver.findElement(amazonSearchbox).sendKeys(Keys.ENTER);
		
	}
public void selectMatchedItem(String item) throws InterruptedException {
	
	List<WebElement> num2=driver.findElements(orginalPrice);
	for(WebElement num:num2) {
		String str=num.getText();
		if(str.length()>2) {
			if((num.getText().substring(1)).equals(item)) {
				Thread.sleep(3000);
				Actions actions = new Actions(driver);
				actions.moveToElement(num).click().build().perform();
				
				break;

			}
		}

	}
	
}

}
