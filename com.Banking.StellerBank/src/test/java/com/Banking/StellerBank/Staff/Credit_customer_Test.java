package com.Banking.StellerBank.Staff;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import stellerBank_POM.Application_Home_Page;
import stellerBank_POM.Approve_Pendind_Account_Page;
import stellerBank_POM.Confirm_Page;
import stellerBank_POM.Credit_Amount_Page;
import stellerBank_POM.Register_Page;
import stellerBank_POM.Staff_Home_Page;
import stellerBank_POM.Staff_Login_Page;
import stellerBank_generic.BaseclassUtility;
import stellerBank_generic.ExcelUtility;
import stellerBank_generic.FileUtility;
import stellerBank_generic.JavaUtility;
import stellerBank_generic.WebDriverUtility;

@Listeners
public class Credit_customer_Test extends BaseclassUtility  
{
	@Test(groups="SmokeTest")
    public void credit_Customer_Module() throws EncryptedDocumentException, IOException 
//	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		   
		   ExcelUtility elib=new ExcelUtility();
		   JavaUtility jlib=new JavaUtility();
		   FileUtility flib=new FileUtility();
		   WebDriverUtility wlib = new WebDriverUtility();
		   
		    Application_Home_Page application_home_page=new Application_Home_Page(driver);
		    Register_Page register_Page=new Register_Page(driver);
		    Confirm_Page confirm_Page=new Confirm_Page(driver);
		    Staff_Login_Page  staff_Login_Page=new Staff_Login_Page(driver);
		    Staff_Home_Page staff_Home_Page=new Staff_Home_Page(driver);
		    Approve_Pendind_Account_Page approve_Pendind_Account=new Approve_Pendind_Account_Page(driver);
		    Credit_Amount_Page credit_Amount_Page=new Credit_Amount_Page(driver);
			
//			//verifying the application home page
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
			
			//verifying the application home page
			verify="Online Banking System";
			display="Application Home page";
			wlib.get_Title(driver, verify, display);
			
			//Click on Staff login_button
			application_home_page.Staff_login_button();
			
			//Verifying staff home page is displaying
			verify="Staff";
			display="Staff login page";
			wlib.get_Title(driver, verify, display);
			
			staff_Login_Page.Enter_Details_into_Loginpage(driver, elib, "Staff Login Cred");
			
			//Click on Staff login_button
			staff_Login_Page.Login_Button();
			
			//Verifying staff home page is displaying
			verify="Staff Home";
			display="Staff Home page";
			wlib.get_Title(driver, verify, display);
			
			//Click on Approve Account 
			staff_Home_Page.Approve_Pending_Account_button();
			
			//Verifying staff home page is displaying
			verify="Pending Customers";
			display="Pending Customers page";
			wlib.get_Title(driver, verify, display);
			
			//Entering application number into the application number textfield
			approve_Pendind_Account.Application_Number_Textfield(ApplicationNumber);
			
			//Click on search button
			approve_Pendind_Account.Search_Button();
			
			//Verifying staff home page is displaying
			verify="Pending Customers";
			display="Pending Customers page";
			wlib.get_Title(driver, verify, display);
			
			// Click on approve button
			approve_Pendind_Account.Approve_Button();
			
			//Verifying account created successfully popup is displaying
			verify="Account Created Successfully";
			display="Account created successfully popup";
			text =wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);

			// Initializing the variable using Account no
			String AccountNumber="";
			for (int i = 0; i <text.length(); i++) 
			{
				if(Character.isDigit(text.charAt(i)))
				{
					AccountNumber=AccountNumber+text.charAt(i);
				}
				
			}
			
			// Storing AAcount number in Excel
			elib.insert_Data_Into_Excel("Account", 1, 0, AccountNumber);
			
			 //Verifying Pending Customers page is displaying
			wlib.get_Title(driver, "Pending Customers", "Pending Customers page");
		  	
			//Click on Home Button
			approve_Pendind_Account.Home_Button();
			
			//Verifying staff home page is displaying
			verify="Staff Home";
			display="Staff Home page";
			wlib.get_Title(driver, verify, display);
			
			//Click on Home Button
			staff_Home_Page.Credit_customer_Button();
					
			//Verifying Credit Amount page is displaying
			verify="Staff Home";
			display="Credit Amount page";
			wlib.get_Title(driver, verify, display);
			
			//Entering Account Number into the Account Number textfield
			String AccountNumber1=elib.get_Perticular_Data_From_Excel("Account", "customer_account_no");
			credit_Amount_Page.Customer_Account_Number_Textfield(AccountNumber1);
			
			//Entering Amount into the Amount textfield
			String Amount=elib.get_Perticular_Data_From_Excel("Credit Amount", "credit_amount");
			credit_Amount_Page.Amount_Textfield(Amount);
			
			//Click on Credit Button
			credit_Amount_Page.Submit_Button();
			
			// Verifying Amount credited successfully popup is displaying
			verify="Amount credited Successfully to customer account";
			display="Amount credited Successfully to customer account popup";
			text =wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);
			
			Reporter.log("Credit Customer Test case is pass");	        

	}

}
