package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage
{
public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") private WebElement newadminuser;
	@FindBy(xpath = "//input[@id='username']") private WebElement newadminusersusername;
	@FindBy(xpath = "//input[@id='password']") private WebElement newadminuserspassword;
	@FindBy(xpath = "//select[@id='user_type']") private WebElement newadminusersusertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']") private WebElement save;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") private WebElement searchadminuser;
	@FindBy(xpath = "//input[@id='un']") private WebElement searchadminusersusername; 
	@FindBy(xpath = "//select[@id='ut']") private WebElement searchadminusersusertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']") private WebElement searchentereddetails;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") private WebElement reset;
	
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement admininformation;
    @FindBy(xpath = "//td[text()='colten.stiedemann']") private WebElement usernamesearch;
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") private WebElement adminuserreset;
	
	public AdminUsersPage clickOnNewButton()
	{
		newadminuser.click();
		return this;
	}
	
	public AdminUsersPage enterNewAdminUsersUsernameOnUsernameField(String username)
	{
		newadminusersusername.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterNewAdminUsersPasswordOnPaswwordField(String password)
	{
		newadminuserspassword.sendKeys(password);
		return this;	
	}
	
	public AdminUsersPage selectNewAdminUsersUserType()
	{
		PageUtility page = new PageUtility();
		page.selectDropdownByIndex(newadminusersusertype, 2);
		return this;
	}
	
	public AdminUsersPage clickOnSaveButton()
	{
		save.click();
		return this;
	}
	
	public AdminUsersPage clickOnSearchButton()
	{
		searchadminuser.click();
		return this;
	}
	
	public AdminUsersPage enterSearchAdminUsersUsername(String searchusername)
	{
		searchadminusersusername.sendKeys(searchusername);
		return this;
	}
	
	public AdminUsersPage selectSearchAdminUsersUserType()
	{
		PageUtility page = new PageUtility();
		page.selectDropdownByIndex(searchadminusersusertype, 2);
		return this;
		
	}
      
	public AdminUsersPage clickOnSearchEnteredDetails()
	{
		searchentereddetails.click();
		return this;
	}
	
	public AdminUsersPage clickOnResetButton()
	{
		reset.click();
		return this;
	}
	
	public boolean isNewAdminPageDisplayed()
	{
		return admininformation.isDisplayed();
	}
	
	public boolean isSearchUsernameDisplayed()
	{
		return usernamesearch.isDisplayed();
	}
	
	public boolean isResetAdminUserEnabled()
	{
		//System.out.println(adminuserreset.isEnabled());
		return adminuserreset.isEnabled();
	}
}
