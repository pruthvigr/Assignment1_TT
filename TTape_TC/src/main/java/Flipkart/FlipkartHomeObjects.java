package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class FlipkartHomeObjects {
	private WebDriver driver;
	By searchbox=By.name("q");
	By close=By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By itemElement=By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a");
	public FlipkartHomeObjects(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void closePopUp() {
		driver.findElement(close).click();
	}
	public void searchItem(String item) {
		
		driver.findElement(searchbox).sendKeys(item);
		driver.findElement(searchbox).sendKeys(Keys.ENTER);
		
	}
	public void selectItem() {
		driver.findElement(itemElement).click();
	}

}
