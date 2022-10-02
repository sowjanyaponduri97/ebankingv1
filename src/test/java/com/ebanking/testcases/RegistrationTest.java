package com.ebanking.testcases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ebanking.pageobject.login;

public class RegistrationTest extends BaseClass {
	
	@Parameters({ "browser" , "firefox" })
		@Test
		public  void registerater() throws InterruptedException
		{
			driver.get(baseURL);
			logger.info("url opened");
			login l=new login(driver);
			l.sign();
			l.register();
			l.enterusername(UserName);;
			logger.info("user name entered");
			l.setpassword(PassWord);;
			logger.info("user password entered");
			l.reenter(passwordReentered);;
			logger.info("user password reentered");
			l.submit();
			logger.info("user log in success");
		}
		}

	


