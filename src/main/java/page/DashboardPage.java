package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	
	WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		
	}
	@FindBy(how=How.XPATH, using="//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement DashboardPage_Element;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement Customer_Element;
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Add Customer')]") WebElement 	AddCostumer_Element;
	@FindBy(how=How.XPATH, using="//a[contains(text(),'List Customers')]") WebElement 	ListCostumer_Element;
	
	public void verifyDashboardPage() {
	Assert.assertEquals(DashboardPage_Element.getText(), "Dashboard");
	
	}
	public void clickCustomerButton() {
		Customer_Element.click();
	}
	public void clickAddCustomerButton() {
		AddCostumer_Element.click();
		
	}
	public void clickListCustomerButton() {
		ListCostumer_Element.click();
		
	}

}
