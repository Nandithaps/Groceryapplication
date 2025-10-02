package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base
{
	HomePage homepage;
	AdminUsersPage adminuserspage;
	
	@Test(priority = 1,description = "User is creating a new user in Admin User page")
	public void verifyUserIsAbleToAddNewUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		adminuserspage = homepage.clickOnAdminUsersMoreInfoButton();
		RandomDataUtility randomdata = new RandomDataUtility();
		String newUsername = randomdata.randomUsername();
		String newPassword = randomdata.randomPaswword();
		adminuserspage.clickOnNewButton();
		//adminuserspage.enterNewAdminUsersUsernameOnUsernameField("Nanditha");
		//adminuserspage.enterNewAdminUsersPasswordOnPaswwordField("Newpw");
		adminuserspage.enterNewAdminUsersUsernameOnUsernameField(newUsername).enterNewAdminUsersPasswordOnPaswwordField(newPassword).selectNewAdminUsersUserType().clickOnSaveButton();
		boolean newadmindisplay = adminuserspage.isNewAdminPageDisplayed();
		Assert.assertTrue(newadmindisplay, Constants.NEWADMINUSERERROR);
	}


	@Test(priority = 2,description = "User is searching the list with an existing user details")
	public void verifyUserIsAbleToSearchTheNewUser() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		adminuserspage = homepage.clickOnAdminUsersMoreInfoButton();
		adminuserspage.clickOnSearchButton();
		String adminvalue = ExcelUtility.getStringData(0,0,"AdminUsersPage");
		adminuserspage.enterSearchAdminUsersUsername(adminvalue).selectSearchAdminUsersUserType().clickOnSearchEnteredDetails();
		boolean usernamedisplay = adminuserspage.isSearchUsernameDisplayed();
		Assert.assertTrue(usernamedisplay, Constants.SEARCHADMINUSERERROR);
		
	}
	
	@Test(priority = 3,description = "User clicks on Reset button in Admin user page")
	public void verifyUserIsAbleToResetTheUserList() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = loginpage.clickOnLoginButton();
		adminuserspage = homepage.clickOnAdminUsersMoreInfoButton();
		adminuserspage.clickOnResetButton();
		boolean adminuserreset = adminuserspage.isResetAdminUserEnabled();
		Assert.assertTrue(adminuserreset, Constants.RESETADMINUSERERROR);
	}
}
