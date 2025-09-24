package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base
{
	HomePage homepage;
	@Test(description = "User logout from the application")
	public void verifyUserIsAbleToLogout() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		homepage.clickOnAdminButton();
		loginpage = homepage.clickOnLogoutButton();
		String actual = loginpage.getPageTittle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.LOGOUTERROR);
			
	}

}
