package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilities.DDT_dataprovider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Data {
	@Test(dataProvider = "RecentOne", dataProviderClass = DDT_dataprovider.class)
	public void TestLogin(String userName, String Password) {
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://products.ncryptedprojects.com/fundraiser_v3.1/login");
		d.findElement(By.id("user_email")).sendKeys(userName);
		d.findElement(By.id("user_password")).sendKeys(Password);
		d.findElement(By.name("submitLogin")).click();
		org.testng.Assert.assertEquals(d.getCurrentUrl(), "https://products.ncryptedprojects.com/fundraiser_v3.1/profile");
		
		d.quit();
	}

}
