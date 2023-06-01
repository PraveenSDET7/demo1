package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Change_Password_Page 
{
	@FindBy(name="oldpass") private WebElement Old_Password_Textfield;
	@FindBy(name="cnfrm") private WebElement Confirm_Old_Password_Textfield;
	@FindBy(name="newpass") private WebElement New_Password_Button;
	@FindBy(name="change_pass") private WebElement Change_Password_Button;
	@FindBy(name="home") private WebElement Home_Button;	
	@FindBy(name="logout_btn") private WebElement Logout_Button;
	
		public Change_Password_Page (WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void Old_Password_Textfield(String Password)
		{
			Old_Password_Textfield.sendKeys(Password);
		}
		
		public void  Confirm_Old_Password_Textfield(String Password)
		{
			Confirm_Old_Password_Textfield.sendKeys(Password);
		}
		
		public void New_Password_Button(String Password)
		{
			New_Password_Button.sendKeys(Password);
		}
		
		public void Logout_Button()
		{
			Logout_Button.click();
		}
		
		public void Change_Password_Button()
		{
			Change_Password_Button.click();
		}
		public void Home_Button()
		{
			Home_Button.click();
		}

}
