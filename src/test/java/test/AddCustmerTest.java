package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustmerTest {
	WebDriver driver;

	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\Untitled 1.xls");
	String username = exlread.getCellData("Sheet1", "UserName", 2);
	String password = exlread.getCellData("Sheet1", "Password", 2);
	String fullName=exlread.getCellData("Sheet2", "FullName", 2);
	String company=exlread.getCellData("Sheet2", "CompanyName", 2);
	String email=exlread.getCellData("Sheet2", "Email", 2);
	String phone=exlread.getCellData("Sheet2", "Phone", 2);
	String address=exlread.getCellData("Sheet2", "address", 2);
	String city=exlread.getCellData("Sheet2", "City", 2);
	String state=exlread.getCellData("Sheet2", "State", 2);
	String zip=exlread.getCellData("Sheet2", "Zip", 2);
	String country=exlread.getCellData("Sheet2", "Country", 2);
	
	

	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(username);
		loginpage.insertPassword(password);
		loginpage.clickSignIn();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage=PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompanyName(company);
		//addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		//addCustomerPage.insertCountry(country);
		addCustomerPage.clickSaveButton();
		addCustomerPage.verifyProfilePage();
		
		dashboardPage.clickListCustomerButton();
		
		addCustomerPage.verifyEnteredName();
		
		
		

	}

}
