package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	
	ExcelReader exlread=new ExcelReader("src\\main\\java\\data\\Untitled 1.xls");
	String username=exlread.getCellData("Sheet1", "UserName", 2);
	String password=exlread.getCellData("Sheet1", "Password", 2);
	@Test
	public void validUsershouldBeAbleToLogin() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.insertUserName(username);
		loginpage.insertPassword(password);
		loginpage.clickSignIn();
		
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		
		BrowserFactory.tearDown();
		
		//BrowserFactory.tearDown();
	}

}
