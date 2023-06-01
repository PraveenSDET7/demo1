package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Staff_Home_Page 
{

	@FindBy(name="viewdet") private WebElement View_Active_Customer_button;
	
	@FindBy(name="view_cust_by_ac") private WebElement View_Customer_Details_By_Acno_button;
	
	@FindBy(name="apprvac") private WebElement Approve_Pending_Account_button;
	
	@FindBy(name="del_cust") private WebElement Delete_Customer_button;
	
	@FindBy(name="credit_cust_ac") private WebElement Credit_customer_Button;
	
	@FindBy(name="logout_btn") private WebElement Logout_Button;
	
	
	
	 public Staff_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void View_Active_Customer_button()
	{
		View_Active_Customer_button.click();
	}

	public void View_Customer_Details_By_Acno_button()
	{
		View_Customer_Details_By_Acno_button.click();
	}

	public void Approve_Pending_Account_button()
	{
		Approve_Pending_Account_button.click();
	}

	public void Delete_Customer_button()
	{
		Delete_Customer_button.click();
	}

	public void Credit_customer_Button()
	{
		Credit_customer_Button.click();
	}
	
	public void Logout_Button()
	{
		Logout_Button.click();
	}

}
