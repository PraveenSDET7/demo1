package stellerBank_generic;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseclassUtility
{
	public static WebDriver sdriver;
	public WebDriver driver;
	FileUtility flib = new FileUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	DataBaseUtility dlib = new DataBaseUtility();
	@BeforeSuite(groups={"SmokeTest","regTest"})
	public void connectToDatabase() throws SQLException, InterruptedException
	{
		Thread.sleep(7000);		
		dlib.connect_To_Database();
	}
//	@Parameters("Browser")
    @BeforeClass(groups={"SmokeTest","regTest"})
    public void launchBrowser() throws IOException
    {
    	String value=flib.get_Property_Value("Browser");
//		String value=Browser;
    	if(value.equalsIgnoreCase("Chrome"))
    	{
    		driver=new ChromeDriver();
    	}
    	else if(value.equalsIgnoreCase("firefox"))
    	{
    		driver=new FirefoxDriver();
    	}
    	else 
    	{
    		driver =new EdgeDriver();
    	}
        	sdriver=driver;
    }
    @BeforeMethod(groups={"SmokeTest","regTest"})
    public void launchApplication() throws IOException
    {
    	wlib.wait_Till_Page_Gets_Loaded(driver);
    	driver.get(flib.get_Property_Value("Url"));
    	wlib.maximize_Window(driver);
    }
    @AfterMethod(groups={"SmokeTest","regTest"})
    public void closeApplication() throws IOException
    {
//    	driver.close();
    }
    @AfterClass(groups={"SmokeTest","regTest"})
    public void closeBrowser() throws IOException
    {
    	driver.quit();	
    }
    @BeforeSuite(groups={"SmokeTest","regTest"})
	public void disconnectFromDatabase() throws SQLException
	{
		dlib.disconnect_From_Database();
	}
}
