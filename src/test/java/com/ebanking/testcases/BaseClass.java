package com.ebanking.testcases;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ebanking.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	Readconfig config = new Readconfig();

	public String baseURL = config.getapplicationurl();
	public String UserName = config.getusername();
	public String PassWord = config.getpassword();
	public String passwordReentered = config.getrepassword();
	public static Logger logger;
	
	
	static WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
		public void setup(String br)
		{
			logger= Logger.getLogger("ebankingv1");
			PropertyConfigurator.configure("C:\\Users\\kolla\\Downloads\\selenium-java-4.1.4\\ebankingv1\\log4j. properties");
			
			if(br.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup(); //will automatically import the chrome driver//System.getProperty("user.dir")-> project home directory
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			if(br.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup(); //will automatically import the chrome driver//System.getProperty("user.dir")-> project home directory
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			
			driver.get(baseURL);
		
	
}
	
	@AfterClass

	public void teardown() {
		driver.quit();
	}
	public void capturescreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//screenshots//"+tname+".png");
		FileUtils.copyFile(src, destination);
		System.out.println("Failed screenshot hasbeen taken and stored.");
	}

}
