package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Readconfig {
	public String baseURL="https://www.amazon.com/";
	public String UserName="Sowjanya";
	public String PassWord="Satwik@12";
	public String passwordReentered="Satwik@12";
	public static String ChromePath="C:/Users/kolla/Downloads/selenium-java-4.1.4/ebankingv1/drivers/chromedriver_win32/chromedriver.exe";
	public static String FirefoxPath="C:/Users/kolla/Downloads/selenium-java-4.1.4/ebankingv1/drivers/geckodriver-v0.31.0-win64/geckodriver.exe";
	public static WebDriver driver;
	public static Logger log;
	
	Properties pro;
	public Readconfig()
	{
		File src=new File("C:\\Users\\kolla\\Downloads\\selenium-java-4.1.4\\ebankingv1\\configurations\\config.properties");
		try
		{
			FileInputStream fis =new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("exception is:"+e.getMessage());
		}
	}
	
	public String getapplicationurl()
	{
		String url=pro.getProperty("baseURL");
		System.out.println(url);
		return(url);
	}
	

	  
	
	public String getusername()
	{
		String uname=pro.getProperty("UserName");
		return(uname);
	}
	public String getpassword()
	{
		String pwd=pro.getProperty("PassWord");
		return(pwd);
	}
	public String getrepassword()
	{
		String pre=pro.getProperty("passwordReentered");
		return(pre);
	}
	public String getchromepath()
	{
		String pre=pro.getProperty("ChromePath");
		return(pre);
	}
	public String getfirefoxpath()
	{
		String pre=pro.getProperty("Firefoxpath");
		return(pre);
	}
	
	}
