package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stellerBank_generic.WebDriverUtility;

public class Fund_Transfer_Page 
{
	@FindBy(name="view_beneficiary") private WebElement View_Beneficiary_Button;
	@FindBy(name="delete_beneficiary") private WebElement Delete_Beneficiary_Button;
	@FindBy(name="add_beneficiary") private WebElement Add_Beneficiary_Button;
	@FindBy(name="fnd_trns_btn") private WebElement Amount_Transfer_Button;
	@FindBy(name="logout_btn") private WebElement Logout_Button;
	@FindBy(name="home") private WebElement Home_Button;
	@FindBy(name="beneficiary") private WebElement Select_Beneficiary_Drapdown;
	@FindBy(name="trnsf_amount") private WebElement Amount_Textfield;
	@FindBy(name="trnsf_remark") private WebElement Remark_Textfield;
	
	public Fund_Transfer_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void View_Beneficiary_Button()
	{
		View_Beneficiary_Button.click();
	}
	
	public void Delete_Beneficiary_Button()
	{
		Delete_Beneficiary_Button.click();
	}
	
	public void Add_Beneficiary_Button()
	{
		Add_Beneficiary_Button.click();
	}
	
	public void Amount_Transfer_Button()
	{
		Amount_Transfer_Button.click();
	}
	
	public void Logout_Button()
	{
		Logout_Button.click();
	}
	
	public void Select_Beneficiary_Drapdown(WebDriverUtility wlib, String Visible_text)
	{
		wlib.select_OPtion_Based_On_Value(Select_Beneficiary_Drapdown, Visible_text);
	}
	
	public void  Amount_Textfield(String Amount)
	{
		 Amount_Textfield.sendKeys(Amount);
	}
	
	public void Remark_Textfield(String Remark)
	{
		Remark_Textfield.sendKeys(Remark);
	}
	
	

}
