package com.ebanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	public WebDriver driver;
	public login(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/span")
	WebElement signin;
	
	@FindBy(id="createAccountSubmit")
	WebElement registration;
	
	@FindBy(id="ap_customer_name")
	WebElement username;
	
	@FindBy(id="ap_email")
	WebElement email;
	@FindBy(id="ap_password")
	WebElement password;
	@FindBy(id="ap_password_check")
	WebElement reenterpassword;
	@FindBy(id="continue")
	WebElement continuebtn;
	
	public void sign()
	{
		signin.click();
	}
	public void register()
	{
		registration.click();
	}
	public void enterusername(String uname)
	{
		username.sendKeys("uname");
	}
	public void setpassword(String passwordname)
	{
		password.sendKeys("passwordname");	
	}
	
	public void reenter(String repassword)
	{
		reenterpassword.sendKeys("repassword");
	}
	public void submit()
	{
		continuebtn.click();	
	}
	
}
