package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Pages.HospitalRunLoginPage;

public class HospitalRunBaseclass 
{
	public static HospitalRunLoginPage HospitalRunLoginPageObject;
	public static Properties prope;
	public static File f;
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Actions action;

	public static void intialisation() throws IOException
	{
		String filepath=System.getProperty("user.dir")+"\\src\\main\\java\\configur.properties";
		f=new File(filepath);
		prope=new Properties();
		fis=new FileInputStream(f);
		prope.load(fis);
	}
	public static void browserintilisation()
	{
		//if(prope.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			
			//System.setProperty("webdriver.chrome.driver", prope.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			//driver=new ChromeDriver();
		}
		 if(prope.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gicko.driver", prope.getProperty("user.dir")+"\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		action=new Actions(driver);
	}
	public static void launchUrl()
	{
		driver.get(prope.getProperty("URL"));
	}
	public static void cleardata(WebElement element)
	{
		element.clear();
	}
	public static void click(WebElement element)
	{
		element.click();
	}
	public static void movetoElement(WebElement element)
	{
		action.moveToElement(element).build().perform();
	}
	public static void senddata(WebElement element, String data) 
	{
		element.sendKeys(data);
	}

	public static void pageIntialization()
	{
		HospitalRunLoginPageObject=PageFactory.initElements(driver, HospitalRunLoginPage.class);
	}
	public static void loginfun()
	{
		click(HospitalRunLoginPageObject.login_Go_to_the_Demo);
		senddata(HospitalRunLoginPageObject.login_username, prope.getProperty("username"));
		senddata(HospitalRunLoginPageObject.login_password, prope.getProperty("password"));
		click(HospitalRunLoginPageObject.login_btn);
	}

}
