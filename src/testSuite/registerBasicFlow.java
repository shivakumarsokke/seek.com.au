package testSuite;

import objectMap.ObjectMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class registerBasicFlow {
	

	public static ObjectMap objMap = new ObjectMap(seekLandingPage.objectMapPath+"\\objectPropertiesFile\\objectMap.properties");



@Test
public void registerNewUser() throws Exception {
	
	
	
	//open Seek com home page
	seekLandingPage.openBrowser();
	
	
	//click register user link on home page
	clickRegisterUser();

	
	//input register user forma data
	inputRegisterUserFormdata();
	
	
	//click on Next Button
	seekLandingPage.driver.findElement(objMap.getLocator("signInButton")).click();
	
	
	//Validate Register form with some key text
	Assert.assertTrue(seekLandingPage.driver.getPageSource().contains("let's get your profile started"));
		

	
	
	
	
	
	
}
 

public void clickRegisterUser() throws Exception{
	WebElement registerLink = seekLandingPage.driver.findElement(objMap.getLocator("registerUser"));
	registerLink.click();
	
}

public void inputRegisterUserFormdata() throws Exception{
	WebElement inputFirstName =seekLandingPage.driver.findElement(objMap.getLocator("registerFirstName"));
	inputFirstName.clear();
	inputFirstName.sendKeys(objMap.getValue("inputRegisterFirstName"));
	
	WebElement inputLastName =seekLandingPage.driver.findElement(objMap.getLocator("registerLastName"));
	inputLastName.clear();
	inputLastName.sendKeys(objMap.getValue("inputRegisterLastName"));
	
	WebElement inputEmail =seekLandingPage.driver.findElement(objMap.getLocator("registerEmail"));
	inputEmail.clear();
	inputEmail.sendKeys(objMap.getValue("inputRegisterEmail"));
	
	WebElement inputPassword =seekLandingPage.driver.findElement(objMap.getLocator("registerPassword"));
	inputPassword.clear();
	inputPassword.sendKeys(objMap.getValue("inputregisterPassword"));
	
	
	//Check checkBox
	if(!	seekLandingPage.driver.findElement(By.xpath(".//input[@checked='checked']")).isSelected()){
		seekLandingPage.driver.findElement(By.xpath(".//input[@checked='checked']")).click();
	}
	
}
 
 
 
 
 
 
 
 
 
	
	
	
	
	
	
	
	
	

}
