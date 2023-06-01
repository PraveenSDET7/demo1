package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirm_Page 
{
	@FindBy(name="cnfrm-submit") private WebElement Confirm_Button;
	
	public Confirm_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void Confirm_Button()
	{
		Confirm_Button.click();
	}
}
