package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage 
{
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']") private WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") private WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") private WebElement adminusers;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']") private WebElement managenews;
	

	public HomePage clickOnAdminButton()
	{
		admin.click();
		return this;
	}
	
	public LoginPage clickOnLogoutButton()
	{
		logout.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickOnAdminUsersMoreInfoButton()
	{
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, adminusers);
		adminusers.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageNewsPage clickOnManageNewsMoreInfoButton()
	{
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, managenews);
		managenews.click();
		return new ManageNewsPage(driver);
	}
}
