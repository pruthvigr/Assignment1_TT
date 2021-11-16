package Common;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchWindow {
	WebDriver driver;
	public SwitchWindow(WebDriver driver) {
		this.driver=driver;
	}


	public void switchToWindow(int i) {
		String currentHandle= driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String actual: handles) {
			int j=0;
			if(!actual.equalsIgnoreCase(currentHandle) & j<i) {
				//Switch to the opened tab
				driver.switchTo().window(actual); 

			}
			j++;

		}
	}
}