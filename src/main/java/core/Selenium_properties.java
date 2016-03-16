package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.imageio.IIOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
 

public class Selenium_properties 
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		String text_case_id = null;
		String url = null;
		String title_expected = null;
		
		Properties properties = new Properties();
		try 
		{
			properties.load(new FileInputStream(" ./src/main/resources/Test.properties"));
			text_case_id = properties.getProperty(text_case_id);
			url = properties.getProperty(url);
			title_expected = properties.getProperty(title_expected);
		}
		catch (IIOException e)
		{
			e.printStackTrace();
		}
		
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = driver.getTitle();
		
		if (title_expected.equals(title_actual))
		{
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t"+ url);
			System.out.println("Title expected: \t\t" + title_expected);
			System.out.println("Title actual: \t\t" + title_actual);
			System.out.println("Test case result: \t" + "PASSED");
						
		}
		else
		{
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t"+ url);
			System.out.println("Title expected: \t\t" + title_expected);
			System.out.println("Title actual: \t\t" + title_actual);
			System.out.println("Test case result: \t" + "FAILED");
		}
		driver.quit();
		
		}
	}