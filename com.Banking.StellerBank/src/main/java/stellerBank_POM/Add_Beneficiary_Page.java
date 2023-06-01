package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stellerBank_generic.WebDriverUtility;

public class Add_Beneficiary_Page 
{
	@FindBy(name="beneficiary_name") private WebElement Beneficiary_Name_Textfield;
	@FindBy(name="beneficiary_acno") private WebElement Beneficiary_Account_No_Textfield;
	@FindBy(name="Ifsc_code") private WebElement IFSC_Code_Textfield;
	@FindBy(name="logout_btn") private WebElement Logout_Button;
	@FindBy(name="home") private WebElement Home_Button;
	@FindBy(name="beneficiary_acc_type") private WebElement Account_Type_Drapdown;
	@FindBy(name="add_beneficiary_btn") private WebElement Add_Button;
	@FindBy(xpath="//a[@href='fund_transfer.php']/li") private WebElement Foun_Transfer_Button;
	
	
	public Add_Beneficiary_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void Beneficiary_Name_Textfield(String Name)
	{
		Beneficiary_Name_Textfield.sendKeys(Name);
	}
	
	public void Beneficiary_Account_No_Textfield(String Account_no)
	{
		Beneficiary_Account_No_Textfield.sendKeys(Account_no);
	}
	
	public void IFSC_Code_Textfield(String IFSC_no)
	{
		IFSC_Code_Textfield.sendKeys(IFSC_no);
	}
	
	public void Logout_Button()
	{
		Logout_Button.click();
	}
	
	public void  Account_Type_Drapdown(WebDriverUtility wlib, String Visible_text)
	{
		wlib.select_OPtion_Based_On_Visibletext( Account_Type_Drapdown, Visible_text);
	}
	
	public void Add_Button()
	{
		Add_Button.click();
	}
	
	public void Foun_Transfer_Button()
	{
		Foun_Transfer_Button.click();
	}
	
	public void Home_Button()
	{
		Home_Button.click();
	}

}
