package stellerBank_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OTP_Verification_Page 
{
	@FindBy(xpath="//label[@class='OTP_msg']") private WebElement Verification_Text;
	@FindBy(xpath="//div[@class='fund_transfer_otp_container']//input[1]") private WebElement OTP_Textfield;
	@FindBy(xpath="//div[@class='fund_transfer_otp_container']//input[2]") private WebElement Verify_button;
	
	public OTP_Verification_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String  Verification_Text()
	{
		return Verification_Text.getText(); 
	}
	
	public void OTP_Textfield(String OTP)
	{
		OTP_Textfield.click();
		OTP_Textfield.sendKeys(OTP);
	}
	
	public void Verify_button()
	{
		Verify_button.click();
	}

}
