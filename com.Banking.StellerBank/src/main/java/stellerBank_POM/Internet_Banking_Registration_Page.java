package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Internet_Banking_Registration_Page 
{
	@FindBy(name="holder_name") private WebElement Account_Holdername_Textfield;
	@FindBy(name="mobile") private WebElement Mobile_Textfield;
	@FindBy(name="dob") private WebElement DateofBirth_Textfield;
	@FindBy(name="pan_no") private WebElement Pan_Number_Textfield;
	@FindBy(name="accnum") private WebElement Account_Number_Textfield;
	@FindBy(name="dbtcard") private WebElement Debit_Card_Number_Textfield;
	@FindBy(name="dbtpin") private WebElement Debit_Card_Pin_Number_Textfield;
	@FindBy(name="last_trans") private WebElement Last_Transaction_Textfield;
	@FindBy(name="password") private WebElement Password_Textfield;
	@FindBy(name="cnfrm_password") private WebElement Confirm_Password_Textfield;
	@FindBy(name="submit") private WebElement Submit_Button;
	@FindBy(name="Home") private WebElement Home_Button;
		
		public Internet_Banking_Registration_Page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void Account_Holdername_Textfield(String Account_Number)
		{
			Account_Holdername_Textfield.sendKeys(Account_Number);
		}
		
		public void Mobile_Textfield(String Mobile)
		{
			Mobile_Textfield.sendKeys(Mobile);
		}
		
		public void DateofBirth_Textfield(String Day,String Mon,String Year)
		{
			DateofBirth_Textfield.click();
			DateofBirth_Textfield.sendKeys(Day);
			DateofBirth_Textfield.sendKeys(Mon);
			DateofBirth_Textfield.sendKeys(Year);
		}
		
		public void Pan_Number_Textfield(String Pan)
		{
			Pan_Number_Textfield.sendKeys(Pan);
		}
		
		public void Account_Number_Textfield(String Acno)
		{
			Account_Number_Textfield.sendKeys(Acno);
		}
		
		public void Last_Transaction_Textfield(String Last_Trans)
		{
			Last_Transaction_Textfield.sendKeys(Last_Trans);
		}
		
		public void Debit_Card_Number_Textfield(String Card_Number)
		{
			Debit_Card_Number_Textfield.sendKeys(Card_Number);
		}
		
		public void Debit_Card_Pin_Number_Textfield(String Pin_Number)
		{
			Debit_Card_Pin_Number_Textfield.sendKeys(Pin_Number);
		}
		
		public void Password_Textfield(String Password)
		{
			Password_Textfield.sendKeys(Password);
		}
		
		public void Confirm_Password_Textfield(String Con_Password)
		{
			Confirm_Password_Textfield.sendKeys(Con_Password);
		}
		
		public void Submit_Button()
		{
			Submit_Button.click();
		}
		
		public void Home_Button()
		{
			Home_Button.click();
		}

}
