package com.Banking.StellerBank.User;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import stellerBank_POM.Application_Home_Page;
import stellerBank_POM.Approve_Pendind_Account_Page;
import stellerBank_POM.Confirm_Page;
import stellerBank_POM.Register_Page;
import stellerBank_POM.Staff_Login_Page;
import stellerBank_generic.BaseclassUtility;
import stellerBank_generic.ExcelUtility;
import stellerBank_generic.FileUtility;
import stellerBank_generic.JavaUtility;
import stellerBank_generic.WebDriverUtility;

public class Open_Account_Test extends BaseclassUtility
{
	@Test(groups="regTest")
	public void Open_Account_Module() throws EncryptedDocumentException, IOException 
//	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{	
		//		WebDriver driver=new ChromeDriver();
		   
		   ExcelUtility elib=new ExcelUtility();
		   FileUtility flib=new FileUtility();
		   WebDriverUtility wlib = new WebDriverUtility();
		   
		    Application_Home_Page application_home_page=new Application_Home_Page(driver);
		    Register_Page register_Page=new Register_Page(driver);
		    Confirm_Page confirm_Page=new Confirm_Page(driver);
		    Staff_Login_Page staff_Login_Page=new Staff_Login_Page(driver);
	
 			
		  //verifying the application home page
 			String verify="Online Banking System";
 			String display="Application Home page";
 			wlib.get_Title(driver, verify, display);
 			
 			
 			// click on open account button
 			application_home_page.Open_Account_button();
 			
 			//verifying the Online account opening form
 			verify="Registration Form";
 			display="Online account opening form";
 			wlib.get_Title(driver, verify, display);
 			
 			register_Page.enter_Details_Register(driver, elib, "Register");
 			String Day=elib.get_Data_From_Excel("Register", 1, 5);
			String Mon=elib.get_Data_From_Excel("Register", 1, 6);
			String Year=elib.get_Data_From_Excel("Register", 1, 7);
			register_Page.DateofBirth_Textfield(Day, Mon, Year);
			
			// Entering Name into the Name textfield
			String Name=elib.get_Data_From_Excel("Register", 1, 0);                           
			String Mobile=elib.get_Data_From_Excel("Register", 1, 2);
			String Pan=elib.get_Data_From_Excel("Register", 1, 8); 				 
			String account_type=elib.get_Data_From_Excel("Register", 1, 18);
			
			//Click on submit Button
			register_Page.Submit_Button(); 
			
			// Verifying Confirm page is displaying
			verify="Confirm";
			display="Confirm page";
			wlib.get_Title(driver, verify, display);
			
			//Click on Confirm_submit Button
			confirm_Page.Confirm_Button(); 
			
			// Verifying Application submitted successfully popup is displaying
			verify="Application submitted successfully";
			display="Application submitted successfully popup";
			String text = wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);
			
			
			// Initializing the variable using Application no
			String ApplicationNumber="";
			for (int i = 0; i <text.length(); i++) 
			{
				if(Character.isDigit(text.charAt(i)))
				{
					ApplicationNumber=ApplicationNumber+text.charAt(i);
				}
				
			}
			//storing ApplicationNumber into Excel Sheet
			elib.insert_Data_Into_Excel("Application", 1, 0, ApplicationNumber);
			
			Reporter.log("Open Account Test Case is Pass");

	}

}
