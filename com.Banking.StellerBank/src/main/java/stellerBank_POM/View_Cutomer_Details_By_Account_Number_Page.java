package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class View_Cutomer_Details_By_Account_Number_Page 
{
	@FindBy(name="account_no") private WebElement Account_Number_Textfield;
	@FindBy(name="submit_view") private WebElement Submit_Button;
	@FindBy(xpath="//div[@class='cust_details']/label[2]") private WebElement Get_text_And_verify; 
		public View_Cutomer_Details_By_Account_Number_Page (WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void  Account_Number_Textfield(String Account_number)
		{
			Account_Number_Textfield.sendKeys(Account_number);
		}
		
		public void  Get_text_And_verify(String Verify, String Display)
		{
			String text=Get_text_And_verify.getText();
			if(text.contains(Verify))
			{
				System.out.println(Display+" displaying");
			}
			else
			{
				System.out.println(Display+" not displaying");
			}
		}
		
		public void  Submit_Button()
		{
			Submit_Button.click();
		}

}
