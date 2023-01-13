package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		
	}

	@FindBy(how=How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement AddContact_Element;
	@FindBy(how=How.XPATH, using="//input[@id='account']") WebElement FullName_Element;
	@FindBy(how=How.XPATH, using="//select[@id='cid']") WebElement CompanyName_Element;
	@FindBy(how=How.XPATH, using="//input[@id='email']") WebElement Email_Element;
	@FindBy(how=How.XPATH, using="//input[@id='phone']") WebElement PhoneNumber_Element;
	@FindBy(how=How.XPATH, using="//input[@id='address']") WebElement Address_Element;
	@FindBy(how=How.XPATH, using="//input[@id='city']") WebElement City_Element;
	@FindBy(how=How.XPATH, using="//input[@id='state']") WebElement State_Element;
	@FindBy(how=How.XPATH, using="//input[@id='zip']") WebElement Zip_Element;
	@FindBy(how=How.XPATH, using="//select[@id='country']") WebElement Country_Element;
	@FindBy(how=How.XPATH, using="//button[@id='submit']") WebElement SaveButton_Element;
	@FindBy(how=How.XPATH, using="//*[@id=\"application_ajaxrender\"]/table[1]/thead/tr/th") WebElement AccountingSummary_Element;
	
	public void verifyAddContactPage() {
		
		
		waitForElement(driver, 3,AddContact_Element);
		Assert.assertEquals(AddContact_Element.getText(), "Add Contact", "wrong page");
		
	}
	String enterName;
	public void insertFullName(String fullName) {
		enterName=fullName + generatenewNumber(999);
		
		FullName_Element.sendKeys(enterName);
	}
	public void insertCompanyName(String company) {
		
		
		selectFromDropdown(CompanyName_Element, company);
	}
	
	
	 public void insertEmail(String email) {
	 Email_Element.sendKeys(email); }
	 
	public void insertPhoneNumber(String phone) {
		PhoneNumber_Element.sendKeys(phone+generatenewNumber(999));
	}
	public void insertAddress(String address) {
		Address_Element.sendKeys(address);	
	}
	public void insertCity(String city) {
		City_Element.sendKeys(city);
		}
	public void insertState(String state) {
		State_Element.sendKeys(state);
	}
	public void insertZip(String zip) {
		Zip_Element.sendKeys(zip);
	}
	
//	public void insertCountry(String country) {
//		selectFromDropdown(Country_Element, country);
//	}
	public void clickSaveButton() {
		SaveButton_Element.click();
	}
	
public void verifyProfilePage() {
	Assert.assertEquals(AccountingSummary_Element.getText(), "Accounting Summary", "This is wrong page");
	
}
//tbody//tr[1]//td[3];
//tbody//tr[2]//td[3];
//tbody//tr[3]//td[3];
//tbody//tr[4]//td[3];
//tbody//tr[5]//td[3];
//tbody//tr[6]//td[3];
//tbody//tr[7]//td[3];
//tbody//tr[8]//td[3];

String before_xpath="//tbody//tr[";
String after_xpath="]//td[3]";
	public void verifyEnteredName() {
	for(int i=1;i<=10;i++) {
		String enteredActualName=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		System.out.println(enteredActualName);
		Assert.assertEquals(enteredActualName, enterName, "wrong name");
		break;
}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
