package sss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class s1 {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\kolla\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com");
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/span")).click();;
		driver.findElement(By.id("createAccountSubmit")).click();
	}

}
