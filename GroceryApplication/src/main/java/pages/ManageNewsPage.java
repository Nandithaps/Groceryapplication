package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
     

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") private WebElement newmanagenews;
	@FindBy(xpath = "//textarea[@id='news']") private WebElement newmanagenewstext;
	@FindBy(xpath = "//button[@class='btn btn-danger']") private WebElement newmanagenewssave;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") private WebElement newmanagenewssearch;
	@FindBy(xpath = "//input[@name='un']") private WebElement searchmanagenewstext;
	@FindBy(xpath = "//button[@name='Search']") private WebElement searchenteredmanagenews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") private WebElement resetmanagenews;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement newnewsalert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]") private WebElement searchnewsdisplay;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") private WebElement managenewsreset;
	
	public ManageNewsPage clickOnNewNewsButton()
	{
		newmanagenews.click();
		return this;
	}
	
	public ManageNewsPage enterNewManageNewsOnNewsField(String newsvalue)
	{
		newmanagenewstext.sendKeys(newsvalue);
		return this;
	}
	
	public ManageNewsPage clickOnNewsSaveButton()
	{
		newmanagenewssave.click();
		return this;
	}
	
	public ManageNewsPage clickOnNewsSearchButton()
	{
		newmanagenewssearch.click();
		return this;
	}
	
	public ManageNewsPage enterSearchManageNewsTextOnNewsField(String newsvalue)
	{
		searchmanagenewstext.sendKeys(newsvalue);
		return this;
	}
	
	public ManageNewsPage clickOnSearchEnteredManageNewsDetails()
	{
		searchenteredmanagenews.click();
		return this;
	}
	
	public ManageNewsPage clickOnManageNewsResetButton()
	{
		resetmanagenews.click();	
		return this;
	}
	
	public boolean isNewManageNewsPageDisplayed()
	{
		return newnewsalert.isDisplayed();
	}
	
	public String getSearchNewsText()
	{
		return searchnewsdisplay.getText();
	}
	
	public boolean isResetManageUserEnabled()
	{
		//System.out.println(manualnewsreset.isEnabled());
		return managenewsreset.isEnabled();
	}
}
