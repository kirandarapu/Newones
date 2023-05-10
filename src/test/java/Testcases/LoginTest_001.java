package Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import junit.framework.Assert;

@Test//(invocationCount=3)
public class LoginTest_001 extends BaseClass {

	public void logintest() throws InterruptedException, IOException{

		//open URL
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		//create object for the Loginpage
		LoginPage lp=new LoginPage(driver);

		lp.setusermail(useremail);
		//System.out.println("username is enetered");
		logger.info("username");

		Thread.sleep(2000);

		lp.setPassword(upassword);
		logger.info("password");
		Thread.sleep(2000);
		lp.clickLoginbtn();
		logger.info("login button");

		logger.info(driver.getTitle());

		if(driver.getTitle().equals("My profile : Fundraiser")) {
			
			Assert.assertTrue(true);
			logger.info("the testcase is passed");
		//	System.out.println("the test case is passed");
		}else
		{
			CaptureScreen(driver,"loginTEST");
			
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		//lp.clickLogoutbtn();
		//logger.info("the application is closed");

	}
}
