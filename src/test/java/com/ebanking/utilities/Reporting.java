package com.ebanking.utilities;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter {
 public ExtentHtmlReporter htmlreporter;
 public ExtentReports extent;
 public ExtentTest testlogger;
 
 public void onteststart(ITestContext testcontest)
 {
	 String timestamp=new SimpleDateFormat("yyyy,MM,dd,mm,ss").format(new Date());
	 String reportname="test-report"+timestamp+".html";
	 htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extentonreports/"+ reportname);
	 htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/myreports.html");
	 extent.attachReporter(htmlreporter);
	 extent.setSystemInfo("host","local");
	 extent.setSystemInfo("os", "windows");
	 extent.setSystemInfo("Environment", "QA");
	 extent.setSystemInfo("user", "sowjanya");
	 
	 htmlreporter.config().setDocumentTitle("ebankingAutomation");
	 htmlreporter.config().setReportName("smoketest");
	 htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
	 htmlreporter.config().setTheme(Theme.DARK);
 }
	 
	 public void ontestpass(ITestResult result)
	 {
		testlogger=extent.createTest(result.getName());
		testlogger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	 }
	 public void ontestfailure(ITestResult result)
	 {
		 testlogger=extent.createTest(result.getName());
		 testlogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		String Screenshotpath=System.getProperty("user.dir")+"//screenshots//"+result.getName()+".png";
		File screenshot=new File(Screenshotpath);
	if(screenshot.exists())
	{
		try
		{
			testlogger.fail("screenshot is not exist",MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	 }
	 public void ontestskip(ITestResult result)
		{
			testlogger=extent.createTest(result.getName());
			testlogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.BLUE));
		}
	 
	 public void ontestflush(ITestContext context)
	 {
		 extent.flush();
	 }
 
	

	}


