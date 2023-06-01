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
import stellerBank_generic.WebDriverUtility;

public class Staff_Login_Page 
{
@FindBy(name="staff_id") private WebElement Staff_id_Textfield;
@FindBy(name="password") private WebElement Password_Textfield;
@FindBy(name="staff_login-btn") private WebElement Login_Button;
@FindBy(xpath="//a[text()='Home']") private WebElement Home_Button;
	
	public Staff_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void  Staff_id_Textfield(String Staff_id)
	{
		 Staff_id_Textfield.sendKeys(Staff_id);
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
	
	public void Enter_Details_into_Loginpage(WebDriver driver,ExcelUtility elib, String Sheet_name) throws EncryptedDocumentException, IOException
	{
		HashMap<String, String> map = elib.insert_Data_Into_Hash_Map(Sheet_name);
		for(Entry<String, String> entry:map.entrySet())
		{
			driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
		}
	}
	
	
}
