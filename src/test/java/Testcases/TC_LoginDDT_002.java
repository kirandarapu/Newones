package Testcases;

import PageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass {
	
	public void loginDDT(String user,String pwd){
		LoginPage lp=new LoginPage(driver);
		
		lp.setusermail(user);
		logger.info("user");
		lp.setPassword(pwd);
		lp.clickLoginbtn();
	}

}
