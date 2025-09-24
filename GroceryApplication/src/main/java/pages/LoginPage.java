package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // init - to initialise elements
	}
	
	@FindBy(name="username") private WebElement username; // @FindBy - to find elements
	@FindBy(name="password") private WebElement password;
	@FindBy(tagName = "button") private WebElement login;
	
	@FindBy(xpath= "//p[text()='Dashboard']") private WebElement dashboard;
    @FindBy(xpath= "//b[text()='7rmart supermarket']") private WebElement loginpagetittle;
	
	
	public LoginPage enterUsernameOnUsernameField(String usernameValue) 
	{
		username.sendKeys(usernameValue);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String passwordValue)
	{
		password.sendKeys(passwordValue);
		return this;
	}
	
	public HomePage clickOnLoginButton()
	{
		login.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	
	public String getPageTittle()
	{
		return loginpagetittle.getText();
	}

}
