package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	HomePage homepage;
	
	@Test(groups= {"smoke"},priority = 1,description = "User login using valid username and valid password")
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		boolean dashboarddisplay = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay, Constants.VALIDCREDENTIALERROR);
	}
	
	@Test(priority = 2,description = "User login using invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnLoginButton();
		String actual = loginpage.getPageTittle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEERROR);
		
	}
	
	@Test(priority = 3,description = "User login using valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(2,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(2,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnLoginButton();
		String actual = loginpage.getPageTittle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDPASSWORDERROR);
	}
	
	@Test(groups= {"smoke"},priority = 4,description = "User login using invalid username and invalid password", dataProvider = "loginProvider") //retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithInvalidCredentials(String usernameValue, String passwordValue) throws IOException
	{
		//String usernameValue = ExcelUtility.getStringData(3,0,"LoginPage");
		//String passwordValue = ExcelUtility.getStringData(3,1,"LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickOnLoginButton();
		String actual = loginpage.getPageTittle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDCREDENTIALERROR);	
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
