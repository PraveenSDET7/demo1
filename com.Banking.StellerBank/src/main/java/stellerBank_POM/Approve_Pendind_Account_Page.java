package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Approve_Pendind_Account_Page 
{
	@FindBy(name="application_no") private WebElement Application_Number_Textfield;
	@FindBy(name="search_application") private WebElement Search_Button;
	@FindBy(name="approve_cust") private WebElement Approve_Button;	
	@FindBy(name="logout_btn") private WebElement Logout_Button;
	@FindBy(name="home") private WebElement Home_Button;
	
		public Approve_Pendind_Account_Page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void  Application_Number_Textfield(String Application_Number)
		{
			Application_Number_Textfield.click();
			Application_Number_Textfield.sendKeys(Application_Number);
		}
		
		public void  Search_Button()
		{
			Search_Button.click();
		}
		
		public void  Approve_Button()
		{
			Approve_Button.click();
		}
		
		public void Logout_Button()
		{
			Logout_Button.click();
		}

		public void Home_Button()
		{
			Home_Button.click();
		}

}
