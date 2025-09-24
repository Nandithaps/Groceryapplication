package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{
	public void selectDropdownWithValue(WebElement element, String value) 
	{
        Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	
	public void selectDropdownByVisibleText(WebElement element, String text) 
	{
        Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}
	
	public void selectDropdownByIndex(WebElement element, int index) 
	{
        Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}
	
	public void setCheckBox(WebElement checkbox, boolean shouldBeChecked)
	{
		if(checkbox.isSelected() != shouldBeChecked)
		{
			checkbox.click();
		}
	}
	
	public boolean isCheckBoxSelected(WebElement checkbox)
	{
		return checkbox.isSelected();
	}
	
	public void selectRadioButton(WebElement radiobutton)
	{
		if(!radiobutton.isSelected())
		{
			radiobutton.click();
		}
	}
	
	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) 
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void scrollBy(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(arguments[0]. arguments[1])");
	}
	
	
}
