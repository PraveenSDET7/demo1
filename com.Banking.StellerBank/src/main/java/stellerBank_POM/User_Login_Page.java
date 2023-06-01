package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Login_Page
{
	@FindBy(name="customer_id") private WebElement User_id_Textfield;
	@FindBy(name="password") private WebElement Password_Textfield;
	@FindBy(name="login-btn") private WebElement Login_Button;
	@FindBy(name="Home") private WebElement Home_Button;
		
		public User_Login_Page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void User_id_Textfield(String Customer_id)
		{
			User_id_Textfield.sendKeys(Customer_id);
		}
		
		public void  Password_Textfield(String Password)
		{
			Password_Textfield.sendKeys(Password);
		}
		
		public void  Login_Button()
		{
			Login_Button.click();
		}
		
		public void Home_Button()
		{
			Home_Button.click();
		}
}
