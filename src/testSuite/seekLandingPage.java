package testSuite;

import java.util.concurrent.TimeUnit;











import objectMap.ObjectMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class seekLandingPage {
	
	public static String objectMapPath = System.getProperty("user.dir");
	public static DesiredCapabilities cap=null;
	public static WebDriver driver=null;
	public static ObjectMap objMap;
	
	
	public static void openBrowser(){
		
		cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
		driver = new FirefoxDriver(cap);
		driver.manage().deleteAllCookies();
		driver.get("https://www.seek.com.au/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void testLandingPageBasic() throws Exception{
		
		openBrowser();
		String actualTitle;
		String ExpectedTitle;
		
		//Get Expected Title from Object Repository
		objMap =new ObjectMap(objectMapPath+"\\objectPropertiesFile\\objectMap.properties");
		ExpectedTitle =objMap.getValue("homePageTitle");
		 
		 //Get Actual Page title from Test Window
		 actualTitle = driver.getTitle();
		 
		//Validate Landing Page Title 
		 Assert.assertEquals(actualTitle, ExpectedTitle);
				
	}
	
	@Test
	public void testLandingPageHeader() throws Exception{
		
		String actualTitle;
		String ExpectedTitle;
		
		//Get Expected Title from Object Repository
		objMap =new ObjectMap(objectMapPath+"\\objectPropertiesFile\\objectMap.properties");
		ExpectedTitle =objMap.getValue("homePageTitle");
		 
		 //Get Actual Page title from Test Window
		 actualTitle = driver.getTitle();
		 
		//Validate Landing Page Title 
		 Assert.assertEquals(actualTitle, ExpectedTitle);
				
	}
	
	@AfterMethod
	public void teardown(){
		
		driver.quit();
		
		
		
	}
	
	
	
	

}
