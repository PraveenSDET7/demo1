package stellerBank_POM;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stellerBank_generic.ExcelUtility;

public class Credit_Amount_Page 
{
	@FindBy(name="customer_account_no") private WebElement Customer_Account_Number_Textfield;
	@FindBy(name="credit_amount") private WebElement Amount_Textfield;
	@FindBy(name="credit_btn") private WebElement Submit_Button;
	@FindBy(name="logout_btn") private WebElement Logout_Button;
	@FindBy(name="home") private WebElement Home_Button;
		public Credit_Amount_Page(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void  Customer_Account_Number_Textfield(String Staff_id)
		{
			Customer_Account_Number_Textfield.sendKeys(Staff_id);
		}
		
		public void  Amount_Textfield(String Amount)
		{
			Amount_Textfield.sendKeys(Amount);
		}
		
		public void  Logout_Button()
		{
			Logout_Button.click();
		}
		
		public void  Submit_Button()
		{
			Submit_Button.click();
		}
		
		public void Home_Button()
		{
			Home_Button.click();
		}
		
		public void Enter_Details_Into_CreditPage(WebDriver driver,ExcelUtility elib, String Sheet_name) throws EncryptedDocumentException, IOException
		{
			    HashMap<String, String> map = elib.insert_Data_Into_Hash_Map(Sheet_name);
				for(Entry<String, String> entry:map.entrySet())
				{
					driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
				}
			
		}

}
