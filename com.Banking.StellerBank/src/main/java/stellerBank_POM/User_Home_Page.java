package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Home_Page 
{
    @FindBy(xpath="//a[@href='customer_profile_myprofile.php']/li") private WebElement My_Profile_button;
	
	@FindBy(xpath="//a[@href='customer_profile_myacc.php']/li") private WebElement My_Account_button;
	
	@FindBy(xpath="//a[@href='customer_pass_change.php']/li") private WebElement Change_Password_button;
	
	@FindBy(xpath="//a[@href='fund_transfer.php']/li") private WebElement Found_Transfer_button;
	
	@FindBy(xpath="//a[@href='cust_statement.php']/li") private WebElement Statement_Button;
	
	@FindBy(name="home") private WebElement Home_Button;
	
	@FindBy(name="logout_btn") private WebElement Logout_Button;
	
	
	
	 public User_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void My_Profile_button()
	{
		My_Profile_button.click();
	}

	public void My_Account_button()
	{
		My_Account_button.click();
	}

	public void Change_Password_button()
	{
		Change_Password_button.click();
	}

	public void Found_Transfer_button()
	{
		Found_Transfer_button.click();
	}

	public void Statement_Button()
	{
		Statement_Button.click();
	}
	
	public void Home_Button()
	{
		Home_Button.click();
	}
	
	public void Logout_Button()
	{
		Logout_Button.click();
	}

}
