package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stellerBank_generic.WebDriverUtility;

public class Application_Home_Page 
{
	@FindBy(linkText="Staff Login") private WebElement Staff_login_button;
	
	@FindBy(xpath="//a[@href='customer_reg_form.php']/li") private WebElement Open_Account_button;
	
	@FindBy(xpath="//a[@href='debit_card_form.php']/li") private WebElement Apply_Dedit_Card_button;
	
	@FindBy(xpath="//div[@class='ebanking']/a") private WebElement Internet_Banking_button;
	
	@FindBy(xpath="//div[@class='ebanking_options']/ul/a[3]/li") private WebElement Register_button;
	
	@FindBy(xpath="//div[@class='ebanking_options']/ul/a[2]/li") private WebElement Login_button;
	
	@FindBy(xpath="//a[@href='fund_transfer.php']/li") private WebElement Fund_Transfer_button;
	
	
	 public Application_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Staff_login_button()
	{
		Staff_login_button.click();
	}
	
	public void Open_Account_button()
	{
		Open_Account_button.click();
	}
	
	public void Apply_Dedit_Card_button()
	{
		Apply_Dedit_Card_button.click();
	}
	
	public void Internet_Banking_button()
	{
		Internet_Banking_button.click();
	}
	
	public WebElement Mousehover_Internet_Banking_button()
	{
		return Internet_Banking_button;
	}
	
	public void Register_button()
	{
		Register_button.click();
	}
	
	public void Login_button()
	{
		Login_button.click();
	}
	
	public void Fund_Transfer_button()
	{
		Fund_Transfer_button.click();
	}
}
