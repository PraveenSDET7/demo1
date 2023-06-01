package stellerBank_generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class LisimpClass implements ITestListener 
{

	public void onTestFailure(ITestResult result) 
	{
		String testName= result.getMethod().getMethodName();
	
		System.out.println(testName + "===========Execute & i am Listening===========");
		
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseclassUtility.sdriver);
		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
		LocalDateTime data_time=LocalDateTime.now();
		try 
		{
			FileUtils.copyFile(srcFile, new File("./Screenshot/"+testName+data_time+".png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
