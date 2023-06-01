package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Apply_Debit_Card_Page 
{
	@FindBy(name="holder_name") private WebElement Account_Holdername_Textfield;
	@FindBy(name="mob") private WebElement Mobile_Textfield;
	@FindBy(name="dob") private WebElement DateofBirth_Textfield;
	@FindBy(name="pan") private WebElement Pan_Number_Textfield;
	@FindBy(name="acc_no") private WebElement Account_Number_Textfield;
	@FindBy(name="dbt_crd_submit") private WebElement Submit_Button;
	@FindBy(xpath="//a[text()='Home']") private WebElement Home_Button;
		
		public Apply_Debit_Card_Page(WebDriver driver)
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
		
		public void Account_Number_Textfield(String Pan)
		{
			Account_Number_Textfield.sendKeys(Pan);
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
