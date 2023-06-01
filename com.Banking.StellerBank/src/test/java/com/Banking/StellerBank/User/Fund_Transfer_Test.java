package com.Banking.StellerBank.User;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import stellerBank_POM.Add_Beneficiary_Page;
import stellerBank_POM.Application_Home_Page;
import stellerBank_POM.Application_Home_Page;
import stellerBank_POM.Apply_Debit_Card_Page;
import stellerBank_POM.Approve_Pendind_Account_Page;
import stellerBank_POM.Approve_Pendind_Account_Page;
import stellerBank_POM.Change_Password_Page;
import stellerBank_POM.Confirm_Page;
import stellerBank_POM.Credit_Amount_Page;
import stellerBank_POM.Fund_Transfer_Page;
import stellerBank_POM.Internet_Banking_Registration_Page;
import stellerBank_POM.OTP_Verification_Page;
import stellerBank_POM.Register_Page;
import stellerBank_POM.Staff_Home_Page;
import stellerBank_POM.Staff_Login_Page;
import stellerBank_POM.User_Home_Page;
import stellerBank_POM.User_Login_Page;
import stellerBank_generic.BaseclassUtility;
import stellerBank_generic.ExcelUtility;
import stellerBank_generic.FileUtility;
import stellerBank_generic.JavaUtility;
import stellerBank_generic.WebDriverUtility;

public class Fund_Transfer_Test extends BaseclassUtility 
{
	@Test(groups="regTest")
	public void Fund_Transfer_Module() throws EncryptedDocumentException, IOException
//	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{

//		WebDriver driver=new ChromeDriver();
		   
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
		    Apply_Debit_Card_Page apply_Debit_Card_Page=new Apply_Debit_Card_Page(driver);
		    Internet_Banking_Registration_Page internet_Banking_Registration_Page=new Internet_Banking_Registration_Page(driver);
		    User_Login_Page user_Login_Page=new User_Login_Page(driver);
		    User_Home_Page user_Home_Page=new User_Home_Page(driver);
		    Change_Password_Page Change_Password_Page=new Change_Password_Page(driver);
		    OTP_Verification_Page oTP_Verification_Page =new OTP_Verification_Page(driver);
		    Fund_Transfer_Page fund_Transfer_Page=new Fund_Transfer_Page(driver);
		    Credit_Amount_Page credit_Amount_Page=new Credit_Amount_Page(driver);
		    Add_Beneficiary_Page add_Beneficiary_Page=new Add_Beneficiary_Page(driver);
 			
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
			
			//Verifying staff home page is displaying
			verify="Pending Customers";
			display="Pending Customers page";
			wlib.get_Title(driver, verify, display);
		  	
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
			credit_Amount_Page.Customer_Account_Number_Textfield(AccountNumber);
		
			
			//Entering Amount into the Amount textfield
			String Amount=elib.get_Data_From_Excel("Credit Amount", 1, 0);
			credit_Amount_Page.Amount_Textfield(Amount);
			
			//Click on Credit Button
			credit_Amount_Page.Submit_Button();
			
			// Verifying Amount credited successfully popup is displaying
			verify="Amount credited Successfully to customer account";
			display="Amount credited Successfully to customer account popup";
			text =wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);

			//Click on Home Button
			driver.findElement(By.name("home")).click();

			//Verifying staff home page is displaying
			verify="Staff";
			display="Staff Home page";
			wlib.get_Title(driver, verify, display);
			
		    //Click on login button
		  	staff_Home_Page.Logout_Button();
		  	
		    //Verifying staff home page is displaying
		  	verify="Staff";
			display="Staff login page";
			wlib.get_Title(driver, verify, display);
		  	
		  	//Click on login button
		  	staff_Login_Page.Home_Button();
		  	
		    //verifying the application home page
		  	verify="Online Banking System";
			display="Application Home page";
			wlib.get_Title(driver, verify, display);
		  	
			//Click on apply debit card button
			application_home_page.Apply_Dedit_Card_button();
		  	
		    //verifying the Apply Debit Card page page
			verify="Apply Debit Card";
			display="Apply Debit Card page is displaying";
			wlib.get_Title(driver, verify, display);
		  	
		    // Entering Account Holder Name into the Account Holder Name textfield
			apply_Debit_Card_Page.Account_Holdername_Textfield(Name);
		  	
		    // Entering Date of Birth into the Date of Birth textfield
			apply_Debit_Card_Page.DateofBirth_Textfield(Day, Mon, Year);
		  	
		    // Entering Pan Number into the Pan textfield
			apply_Debit_Card_Page.Pan_Number_Textfield(Pan);
		  	
		  	// Entering Mobile Number into the Mobile Number textfield
			apply_Debit_Card_Page.Mobile_Textfield(Mobile);
		  	
		    // Entering Account Number into the Account Number textfield
			apply_Debit_Card_Page.Account_Number_Textfield(AccountNumber);
		  	
		  	// Click on Submit buttun
			apply_Debit_Card_Page.Submit_Button();
		  	
		    //Verifying Debit Card issued successfully popup is displaying
		  	verify="Debit Card issued successfully";
			display="Debit Card issued successfully popup";
			text =wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);
			
			// Initializing the variable
		  	String Pin=text.split("Pin is : ")[1].split(" ")[0].trim();
		  	String D_card_no=text.split("Debit Card No is : ")[1].split(" ")[0].trim();
		  	
		    // Storing Debit card number into Excel
		  	elib.insert_Data_Into_Excel("Apply Debit Card", 1, 0, D_card_no);
		  	
		    // Storing Debit card number into Excel
		  	elib.insert_Data_Into_Excel("Apply Debit Card", 1, 1, Pin);
		  	
		    //Click on Home button
		  	apply_Debit_Card_Page.Home_Button();
		  	
		    //verifying the application home page
		  	verify="Online Banking System";
			display="Application Home page";
			wlib.get_Title(driver, verify, display);
		  	
			//Scrolling to the Internet banking button
		  	WebElement ele = application_home_page.Mousehover_Internet_Banking_button();
		    wlib.scroll_Into_Element(driver, ele);
		  	
		    //Mouse hover on Internet banking button
		  	wlib.mouse_Hover_On_Element(driver, ele);
		  	
		  	//Click on Register button
		  	application_home_page.Register_button();
		  	
		  	//verifying the Internet Banking Registration page
			verify="Internet Banking Registration";
			display="Internet Banking Registration page";
			wlib.get_Title(driver, verify, display);
		  	
		  	//Entering Account Holder Name into Account Holder Name text field
			internet_Banking_Registration_Page.Account_Holdername_Textfield(Name);
		  	
		    //Entering Account Number into Account Number text field
			internet_Banking_Registration_Page.Account_Number_Textfield(AccountNumber);
		  	
		  	//Entering Debit Card Number into Debit Card Number text field
			internet_Banking_Registration_Page.Debit_Card_Number_Textfield(D_card_no);
		  	
		  	//Entering Debit Card Pin into Debit Card Pin text field
			internet_Banking_Registration_Page.Debit_Card_Pin_Number_Textfield(Pin);
		  	
		  	//Entering Registered Mobile Number into Registered Mobile Number text field
			internet_Banking_Registration_Page.Mobile_Textfield(Mobile);
		  	
		    //Entering PAN Number into PAN Number text field
			internet_Banking_Registration_Page.Pan_Number_Textfield(Pan);
		  	
		  	//Entering Date of Birth into Date of Birth text field
			internet_Banking_Registration_Page.DateofBirth_Textfield(Day, Mon, Year);
			
		  	//Entering PAN Number into PAN Number text field
		  	String Last=Amount;
		  	internet_Banking_Registration_Page.Last_Transaction_Textfield(Last);
		  	
		    //Entering Password into Password text field
		  	String password="Praveen";
		  	internet_Banking_Registration_Page.Password_Textfield(password);
		  	
		    //Entering Password into Confirm Password text field
		  	internet_Banking_Registration_Page.Confirm_Password_Textfield(password);
		  	
		  	//Click on Submit button
		  	internet_Banking_Registration_Page.Submit_Button();
		  	
		  	//Verifying Debit Card issued successfully popup is displaying
		  	verify="Registration Successfull";
			display="Registration Successfull popup";
			text =wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);
		  		
		  	// Initializing the variable using Account no
			
			String Cust_id="";
			for (int i = 0; i < text.length(); i++) 
			{
				if(Character.isDigit(text.charAt(i)))
				{
					Cust_id=Cust_id+text.charAt(i);
				}
			}
			
			//Storing Customer_id Into Excel
			elib.insert_Data_Into_Excel("Customer Id", 1, 0, Cust_id);
			
			//verifying the Internet Banking Registration page
			verify="Internet Banking Registration";
			display="Internet Banking Registration page";
			wlib.get_Title(driver, verify, display);
		  	
		    //Click on Home button
		  	driver.findElement(By.linkText("Home")).click();
		  	
		    //verifying the application home page
		  	verify="Online Banking System";
			display="Application Home page";
			wlib.get_Title(driver, verify, display);
		  	
			//Scrolling to the Internet banking button
		  	wlib.scroll_Into_Element(driver, ele);
		  	
		    //Mouse hover on Internet banking button
		  	wlib.mouse_Hover_On_Element(driver, ele);
		  	
		  	//Click on Login button
		  	application_home_page.Login_button();
		  	
		  	//verifying the Login Page page
			verify="Login Page";
			display="Login Page page";
			wlib.get_Title(driver, verify, display);
		  	
		  	//Entering Customer ID into Customer ID text field
			user_Login_Page.User_id_Textfield(Cust_id);
		  	
		  	//Entering Customer ID into Customer ID text field
			user_Login_Page.Password_Textfield(password);
		  	
		  	//Click on Login button
			user_Login_Page.Login_Button();
			
			//verifying the Internet Banking Registration page
			verify="My Profile";
			display="My Profile page";
			wlib.get_Title(driver, verify, display);
			
		    //Click on Fund Transfer button
		  	user_Home_Page.Found_Transfer_button();
		  	
		    //verifying the Fund Transfer page
		  	verify="Fund Transfer";
			display="Fund Transfer page";
			wlib.get_Title(driver, verify, display);
		  	
		    //Click on Add Beneficiary button
			fund_Transfer_Page.Add_Beneficiary_Button();
		  	
		    //verifying the Add Beneficiary page
			verify="Add Beneficiary";
			display="Add Beneficiary page";
			wlib.get_Title(driver, verify, display);
			
		  	
		  	//Initializing variable by Baneficiary name
			String To_name=elib.get_Data_From_Excel("Beneficiary DetailsName", 1, 0);
		    //Initializing variable by Baneficiary Account Number
		  	String To_acc_no=elib.get_Data_From_Excel("Beneficiary DetailsName", 1, 1);
		    //Initializing variable by Baneficiary IFSC
		  	String To_ifsc=elib.get_Data_From_Excel("Beneficiary DetailsName", 1, 2);
		    //Initializing variable by Baneficiary Account Type
		  	String Account_type=elib.get_Data_From_Excel("Beneficiary DetailsName", 1, 3);
		  	
		  	//Entering Beneficiary Name into the Beneficiary Name textfield
		  	add_Beneficiary_Page.Beneficiary_Name_Textfield(To_name);
		  	
		  	//Entering Beneficiary Account Number into the Beneficiary Account Number textfield
		  	add_Beneficiary_Page.Beneficiary_Account_No_Textfield(To_acc_no);
		  	
		  	//Entering Beneficiary IFSC Code into the IFSC Code text field
		  	add_Beneficiary_Page.IFSC_Code_Textfield(To_ifsc);
		  	
		  	//Selecting the Beneficiary Account Type into the Account Type dropdown 
		  	add_Beneficiary_Page.Account_Type_Drapdown(wlib, Account_type);
	  	
		  	//Click on Add Button
		  	add_Beneficiary_Page.Add_Button();
		  	
		  	//Verifying Beneficiary Added successfully popup is displaying
		  	verify="Beneficiary Added successfully";
		  	display="Beneficiary Added successfully popup";
		  	text=wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);
		    
		    //verifying the Add Beneficiary page
		  	verify="Add Beneficiary";
		  	display="Add Beneficiary page";
		  	wlib.get_Title(driver, verify, display);
		  	
		  	//Click on Fund Transfer button
		  	add_Beneficiary_Page.Foun_Transfer_Button();
		  	
		    //verifying the Fund Transfer page
		  	verify="Fund Transfer";
		  	display="Fund Transfer page";
		  	wlib.get_Title(driver, verify, display);
		  	
		  	//Selecting the Beneficiary in Select Beneficiary dropdown
		  	fund_Transfer_Page.Select_Beneficiary_Drapdown(wlib, To_acc_no);
		  	
		  	//Entering the amount into the Amount textfield
			fund_Transfer_Page.Amount_Textfield(Amount);
		  	
		    //Entering the Comment into the Remark textfield
			fund_Transfer_Page.Remark_Textfield("Testing");
		  	
		    //Click on Send button
			fund_Transfer_Page.Amount_Transfer_Button();
		  	
		  	//verifying the OTP Verification page
			verify="OTP Verification";
		  	display="OTP Verification page";
		  	wlib.get_Title(driver, verify, display);
		  	
		  	//Storing OTP into the Variable
		  	String Fetch=oTP_Verification_Page.Verification_Text();
		  	String OTP_text=Fetch.split(" ")[13];
		  	String OTP="";
		  	for (int i = 0; i < OTP_text.length(); i++) 
		  	{
		  		if(Character.isDigit(OTP_text.charAt(i)))
		  		{
		  			OTP=OTP+OTP_text.charAt(i);
		  		}
				
			}
	  	
		  	//Entering the OTP into the OTP Code textfield
		  	oTP_Verification_Page.OTP_Textfield(OTP);
		  	
		    //Click on Verify button
		  	oTP_Verification_Page.Verify_button();
		  	
		    //Verifying Transaction Successful! popup is displaying
		  	verify="Transaction Successful!";
		  	display="Transaction Successful! popup";
		  	wlib.switch_To_Alert_Popup_And_accept(driver, verify, display);
		  	
		  	Reporter.log("Fund Transfer Test Case is Pass");
	    
	}

}
