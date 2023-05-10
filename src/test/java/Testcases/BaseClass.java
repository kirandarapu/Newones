package Testcases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;



//import io.github.bonigarcia.wdm.WebDriverManager;
///majorly containing common functionality for every testcase
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

//open application,close application
public class BaseClass {

	ReadConfig rc2747=new ReadConfig();
	public String baseURL=rc2747.getApplicationURL();
	public String useremail=rc2747.getUseremailaddress();
	public String upassword=rc2747.getuserpassword();
	public static WebDriver driver;

	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String bro){

		logger=Logger.getLogger("Sample2747");
		PropertyConfigurator.configure("log11.properties");

		if(bro.equals("chrome")){
			//System.setProperty("webdriver.chrome,driver", rc2747.getchromedriverpath());
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bro.equals("firefox")){
			//System.setProperty("webdriver.gecko.driver", rc2747.getfirefoxdriverpath());
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else if(bro.equals("edge")){
			//System.setProperty("webdriver.edge.driver", rc2747.getedgedriverpath());
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}


	}
	
	public void CaptureScreen(WebDriver driver,String tname) throws IOException{
		//initialize the TakesScreenshot class
		TakesScreenshot ts=(TakesScreenshot)driver;
		//store the file into source folder by using getScreenshot method
		File src= ts.getScreenshotAs(OutputType.FILE);
		//
		File target=new File("./Screenshots/"+tname+".png");
		
		FileUtils.copyFile(src, target);
		logger.info("screenshot is taken");
	}
	@AfterClass
	public void teardown(){
		driver.quit();
	}
}