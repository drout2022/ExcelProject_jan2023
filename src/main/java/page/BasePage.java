package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public int generatenewNumber(int i){
		Random random=new Random();
		int generateNumber=random.nextInt();
		return generateNumber;
		
	}
	public void selectFromDropdown(WebElement element, String visibleText) {
		
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void waitForElement(WebDriver driver, int waitTime, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
