package stellerBank_POM;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stellerBank_generic.ExcelUtility;
import stellerBank_generic.WebDriverUtility;

public class Register_Page 
{
	@FindBy(name="name") private WebElement Name_Textfield;
	
	@FindBy(name="gender") private WebElement Gendr_Dropdown;
	
	@FindBy(name="mobile") private WebElement Mobile_Textfield;
	
	@FindBy(name="email") private WebElement Email_Textfield;
	
	@FindBy(name="landline") private WebElement Landline_Textfield;
	
	@FindBy(name="dob") private WebElement DateofBirth_Textfield;
	
	@FindBy(name="pan_no") private WebElement Pan_Number_Textfield;
	
	@FindBy(name="citizenship") private WebElement Citizenship_Number_Textfield;
	
	@FindBy(name="homeaddrs") private WebElement Home_Address_Textfield;
	
	@FindBy(name="officeaddrs") private WebElement Office_Address_Textfield;
	
	@FindBy(name="state") private WebElement State_Dropdown;
	
	@FindBy(name="city") private WebElement City_Dropdown;
	
	@FindBy(name="pin") private WebElement Pin_Number_Textfield;
	
	@FindBy(name="arealoc") private WebElement Arealocation_Textfield;
	
	@FindBy(name="nominee_name") private WebElement Nominee_Name_Textfield;
	
	@FindBy(name="nominee_ac_no") private WebElement Nominee_Account_Textfield;
	
	@FindBy(name="acctype") private WebElement Account_Type_Dropdown;
	
	@FindBy(name="submit") private WebElement Submit_Button;
	
	public Register_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	WebDriverUtility wlib=new WebDriverUtility();
	
	public void Name_Textfield(String Name)
	{
		Name_Textfield.sendKeys(Name);
	}
	
	
	public void Gendr_Dropdown(String Gender)
	{
		wlib.select_OPtion_Based_On_Visibletext(Gendr_Dropdown, Gender);
	}
	
	public void Mobile_Textfield(String Mobile)
	{
		Mobile_Textfield.sendKeys(Mobile);
	}
	
	public void Email_Textfield(String Email)
	{
		Email_Textfield.sendKeys(Email);
	}
	
	public void Landline_Textfield(String Landline)
	{
		Landline_Textfield.sendKeys(Landline);
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
	
	public void Citizenship_Number_Textfield(String Citezenship)
	{
		Citizenship_Number_Textfield.sendKeys(Citezenship);
	}
	
	public void Home_Address_Textfield(String Home_add)
	{
		Home_Address_Textfield.sendKeys(Home_add);
	}
	
	public void Office_Address_Textfield(String Office_add)
	{
		Office_Address_Textfield.sendKeys(Office_add);
	}
	
	public void State_Dropdown(String State_Name)
	{
		wlib.select_OPtion_Based_On_Visibletext(State_Dropdown, State_Name);
	}
	
	public void City_Dropdown(String City_Name)
	{
		wlib.select_OPtion_Based_On_Visibletext(City_Dropdown, City_Name);
	}
	
	public void Pin_Number_Textfield(String Pin_Number)
	{
		Pin_Number_Textfield.sendKeys(Pin_Number);
	}
	
	public void Arealocation_Textfield(String Area_Loc)
	{
		Arealocation_Textfield.sendKeys(Area_Loc);
	}
	
	public void Nominee_Name_Textfield(String Nominne_Name)
	{
		Nominee_Name_Textfield.sendKeys(Nominne_Name);
	}
	
	public void Nominee_Account_Textfield(String Nominee_Acno)
	{
		Nominee_Account_Textfield.sendKeys(Nominee_Acno);
	}
	
	public void Account_Type_Dropdown(String Account_type)
	{
		wlib.select_OPtion_Based_On_Visibletext(Account_Type_Dropdown, Account_type);
	}
	
	public void Submit_Button()
	{
		Submit_Button.click();
	}
	
	public void enter_Details_Register(WebDriver driver, ExcelUtility elib, String Sheet_name ) throws EncryptedDocumentException, IOException
	{
		
		HashMap<String, String> map = elib.insert_Data_Into_Hash_Map(Sheet_name);
		for(Entry<String, String> entry:map.entrySet())
		{
			if(entry.getKey().equals("dob"))
			{
				
			}
			else if(entry.getKey().contains("gender"))
			{
				WebElement Gendr_Dropdown1=driver.findElement(By.name(entry.getKey()));
				wlib.select_OPtion_Based_On_Visibletext(Gendr_Dropdown1, entry.getValue());
			}
			else if(entry.getKey().contains("state"))
			{
				WebElement State_Dropdown1=driver.findElement(By.name(entry.getKey()));
				wlib.select_OPtion_Based_On_Visibletext(State_Dropdown1, entry.getValue());
			}
			else if(entry.getKey().contains("city"))
			{
				WebElement City_Dropdown1=driver.findElement(By.name(entry.getKey()));
				wlib.select_OPtion_Based_On_Visibletext(City_Dropdown1, entry.getValue());
			}
			else if(entry.getKey().contains("acctype"))
			{
				WebElement Account_type_Dropdown=driver.findElement(By.name(entry.getKey()));
				wlib.select_OPtion_Based_On_Visibletext(Account_type_Dropdown, entry.getValue());
			}
			else 
			{
				driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
			}
		
		}
		
	}
}
