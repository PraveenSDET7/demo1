package stellerBank_generic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class WebDriverUtility
{
	SoftAssert sftassert = new SoftAssert();
	/**
	 * This method is used to Maximize the window
	 * @param driver
	 */
	public void maximize_Window(WebDriver driver)
	{
		driver.manage().window().maximize();	
	}
	/**
	 * This method is used to Minimize the window
	 * @param driver
	 */
	public void minimize_Window(WebDriver driver)
	{
		driver.manage().window().minimize();	
	}
	/**
	 * This method is used to wait Till Page Gets Loaded
	 * @param driver
	 */
	public void wait_Till_Page_Gets_Loaded(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PathConstants.implicitWaitDuration));
		
	}
	/**
	 * This method is used to wait Till Element To Visible
	 * @param driver
	 */
	public void wait_Till_Element_To_Visible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait Till Element To be Clickable
	 * @param driver
	 */
	public void wait_Till_Element_To_Be_Clickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait till title To be Visible
	 * @param driver
	 */
	public void wait_For_A_Title(WebDriver driver,String title )
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(PathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * This method is used to wait till Url To be Visible
	 * @param driver
	 */
	public void wait_For_A_Url(WebDriver driver,String Url )
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(PathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.urlContains(Url));
	}
	
	/**
	 * This method is used to wait till AlertPopup To be Visible
	 * @param driver
	 */
	public void wait_For_Alert_Popup(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(PathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method is used to ignore if its get NoSuchElementException
	 * @param driver
	 */
	public void ignore_No_Such_Element_Exception(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(PathConstants.explicitWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	/**
	 * This method is used to Select option based on the Index
	 * @param driver
	 */
	public void select_OPtion_Based_On_Index(WebElement Element, int Index)
	{
		Select select=new Select(Element);
		select.selectByIndex(Index);
	}
	
	/**
	 * This method is used to Select option based on the Visibletext
	 * @param driver
	 */
	public void select_OPtion_Based_On_Visibletext(WebElement Element, String Text)
	{
		Select select=new Select(Element);
		select.selectByVisibleText(Text);
	}
	
	/**
	 * This method is used to Select option based on the Value
	 * @param driver
	 */
	public void select_OPtion_Based_On_Value(WebElement Element, String Text)
	{
		Select select=new Select(Element);
		select.selectByValue(Text);
	}
	
	/**
	 * This method is used to Select option based on the Id
	 * @param driver
	 */
	public void select_OPtion_Based_On_Id(WebElement Element, String Text)
	{
		Select select=new Select(Element);
		select.selectByValue(Text);
	}
	
	/**
	 * This method is used to Get all Options from DropDown
	 * @param driver
	 */
	public void get_all_Options_From_DropDown(WebElement Element)
	{
		Select select=new Select(Element);
		List<WebElement> options = select.getOptions();
		Iterator<WebElement> iterator = options.iterator();
		sftassert.assertTrue(iterator.hasNext());
		{
			String text = iterator.next().getText();
			System.out.println(text);
		}
	}
	
	/**
	 * This method is used to Get First Selected Option from DropDown
	 * @param driver
	 */
	public void get_First_Selected_Option_From_DropDown(WebElement Element)
	{
		Select select=new Select(Element);
		String option = select.getFirstSelectedOption().getText();
		System.out.println(option);
	}
	
	/**
	 * This method is used to Mouse hover on element
	 * @param driver
	 */
	public void mouse_Hover_On_Element(WebDriver driver,WebElement Element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(Element).perform();
	}
	
	/**
	 * This method is used to Right Click on element
	 * @param driver
	 */
	public void right_Click_On_Element(WebDriver driver,WebElement Element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(Element).perform();
	}
	
	/**
	 * This method is used to Double Click on element
	 * @param driver
	 */
	public void double_Click_On_Element(WebDriver driver,WebElement Element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(Element).perform();
	}
	
	/**
	 * This method is used to Drag And Drap The Element
	 * @param driver
	 */
	public void drag_And_Drap_The_Element(WebDriver driver,WebElement Element,WebElement Element1)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(Element, Element1);
	}
	
	/**
	 * This method is used to Switch To Frame based on Index
	 * @param driver
	 */
	public void switch_To_Frame_Based_On_Index(WebDriver driver,int Index)
	{
		driver.switchTo().frame(Index);
	}
	
	/**
	 * This method is used to Switch To Frame based on Address
	 * @param driver
	 */
	public void switch_To_Frame_Based_On_Address(WebDriver driver,String Address)
	{
		driver.switchTo().frame(Address);
	}
	
	/**
	 * This method is used to Switch to Frame based on ID
	 * @param driver
	 */
	public void switch_To_Frame_Based_On_Id(WebDriver driver,WebElement Element)
	{
		driver.switchTo().frame(Element);
	}
	
	/**
	 * This method is used to Switch from Frame tO Main page
	 * @param driver
	 */
	public void switchFromFrameToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to Switch to Alert Popup and Accept
	 * @param driver
	 */
	public String switch_To_Alert_Popup_And_accept(WebDriver driver, String Verify_text, String display) 
	{
		Alert alrt = driver.switchTo().alert();
		String text=alrt.getText();
		sftassert.assertTrue(text.contains(Verify_text));
		{
			System.out.println(display+" is displaying");
		}
		
		alrt.accept();
		return text;	
	}
	
	/**
	 * This method is used to Switch to Alert Popup and Dismiss
	 * @param driver
	 */
	public void switch_To_Alert_Popup_And_Dismiss(WebDriver driver, String Verify_text, String display)
	{
		Alert alrt = driver.switchTo().alert();
		String text=alrt.getText();
		sftassert.assertTrue(text.contains(Verify_text));
		{
			System.out.println(display+" is displaying");
		}
		alrt.dismiss();
	}
	
	/**
	 * This method is used to Get Title
	 * @param driver
	 */
	public void get_Title(WebDriver driver, String Verify, String disply)
	{
		String title=driver.getTitle();
		sftassert.assertTrue(title.contains(Verify));
		{
			System.out.println(disply +" is displaying");
		}
	}
		
	/**
	 * This method is used to Upload file
	 * @param driver
	 */
	public void file_Upload(WebElement Element,String Path)
	{
		Element.sendKeys(Path);
	}
	
	/**
	 * This method is used to Provide the user Polling period
	 * @param driver
	 */
	public void provide_User_Polling_Period(WebElement Element,long Polling_period)
	{
		int count=0;
		while(count<10)
		{
			try
			{
				Element.click();
				break;
			}
			catch(Exception e)
			{
				try
				{
					Thread.sleep(Polling_period);
				}
				catch(InterruptedException e1)
				{
					e1.printStackTrace();
				}
			}
			count++;
		}
	}
	
	/**
	 * This method is used to take Screen Shot
	 * @param driver
	 * @throws IOException 
	 */
	public String take_Screen_Shot_of_Page(WebDriver driver, String ScreenShotName) throws IOException 
	{
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		LocalDateTime localDateTime=LocalDateTime.now();
		File dst=new File("./ScreenShots/"+ScreenShotName+" "+localDateTime+".png");
		FileUtils.copyFile(src,dst);
		return ScreenShotName;	
	}
	
	
	/**
	 * This method is used to switch to Child Browser
	 * @param driver
	 * @throws IOException 
	 */
	public void switch_To_Child_Browser(String Verify_text,WebDriver driver)
	{
		Set<String> window = driver.getWindowHandles();	
		for (String winid: window) 
		{
			driver.switchTo().window(winid);
			String text = driver.getTitle();
			sftassert.assertTrue(text.contains(Verify_text));
			{
				break;
			}
			
		}
		
	}
	
	/**
	 * This method is used to Scroll Into Element
	 * @param driver
	 * @throws IOException 
	 */
	public void scroll_Into_Element(WebDriver driver,WebElement Element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
	  	js.executeScript("arguments[0].scrollIntoView();",Element);
		
	}
	/**
	 * This method is used to Click on Element
	 * @param driver
	 * @throws IOException 
	 */
	public void click_on_Element(WebDriver driver,WebElement Element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
	  	js.executeScript("arguments[0].click();",Element);
		
	}

}
