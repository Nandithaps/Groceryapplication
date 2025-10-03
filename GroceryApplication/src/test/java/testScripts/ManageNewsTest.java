package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	HomePage homepage;
	ManageNewsPage managenewspage;
	
	
	@Test(priority = 1,description = "User is adding New news in Manage news page")
	public void verifyUserIsAbleToAddNewNews() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		managenewspage = homepage.clickOnManageNewsMoreInfoButton();
		managenewspage.clickOnNewNewsButton();
		String newsvalue = ExcelUtility.getStringData(1,0,"ManageNewsPage");
		managenewspage.enterNewManageNewsOnNewsField(newsvalue).clickOnNewsSaveButton();
		boolean newnewsdisplay = managenewspage.isNewManageNewsPageDisplayed();
		Assert.assertTrue(newnewsdisplay, Constants.NEWMANAGENEWSERROR);
		
	}
	
	@Test(priority = 2,description = "User search for an existing news")
	public void verifyUserIsAbleToSearchTheNewNews() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		managenewspage = homepage.clickOnManageNewsMoreInfoButton();
		managenewspage.clickOnNewsSearchButton();
		String newsvalue = ExcelUtility.getStringData(1,0,"ManageNewsPage");
		managenewspage.enterSearchManageNewsTextOnNewsField(newsvalue).clickOnSearchEnteredManageNewsDetails();
		String actual = managenewspage.getSearchNewsText();
		String expected = "Today's weather";
		Assert.assertEquals(actual, expected, Constants.SEARCHMANAGENEWSERROR);
	}
	
	@Test(priority = 3,description = "User clicks on Reset button in manage news page")
	public void verifyUserIsAbleToResetTheManualList() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		managenewspage = homepage.clickOnManageNewsMoreInfoButton();
		managenewspage.clickOnManageNewsResetButton();
		boolean managenewsreset = managenewspage.isResetManageUserEnabled();
		Assert.assertTrue(managenewsreset, Constants.RESETMANAGENEWSERROR);
	}

}
