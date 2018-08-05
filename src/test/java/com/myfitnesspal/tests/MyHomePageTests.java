package com.myfitnesspal.tests;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.myfitnesspal.pages.LoginPage;
import com.myfitnesspal.pages.MyHomePage;
import com.myfitnesspal.utilities.ConfigurationReader;

public class MyHomePageTests extends TestBase{
	
	
	MyHomePage myhome = new MyHomePage();
	LoginPage login= new LoginPage();
	
	
	
	@Test
	public void SPA1099(){
		
		extentLogger = report.createTest("Negative Image Uploading test");
		//go to homepage
		extentLogger.info("Going to Homepage");
		driver.get(ConfigurationReader.getProperty("url"));
		
		driver.findElement(By.partialLinkText("Log In")).click();
		
		//login
		
		login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		extentLogger.info("Loged in");

		myhome.UploadPhotoLink.click();
		
		
		//verify first title
		
		assertEquals(myhome.TitleYourPhotos.getText(), "Your Photos");
		extentLogger.info("Verified First Title");

		
		//verify second title
		assertEquals(myhome.addMessage.getText(), "Add A New Photo*");
		extentLogger.info("Verified Second Title");

		
		myhome.chooseFileButton.sendKeys("");
		
		myhome.uploadButton.click();
		
		//verify error message
		assertEquals(myhome.errorMessage.getText(), "No Photo Provided");
		myhome.logoutLink.click();
		extentLogger.pass("Verified Error Message");
		
		

		
	}
	
	
	@Test
	public void SPA1100() {
		
				extentLogger = report.createTest("Positive Image Uploding test");
				//go to homepage
				extentLogger.info("Going to Homepage");
				driver.get(ConfigurationReader.getProperty("url"));
				
				driver.findElement(By.partialLinkText("Log In")).click();
				
				//login
				login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
				extentLogger.info("Loged in");

				myhome.UploadPhotoLink.click();
				
				
				//verify the title
				assertEquals(myhome.TitleYourPhotos.getText(), "Your Photos");
				extentLogger.info("Verified First Title");

				//verify second title
				assertEquals(myhome.addMessage.getText(), "Add A New Photo*");
				extentLogger.info("Verified Second Title");

				myhome.chooseFileButton.sendKeys(System.getProperty("user.dir")+"/src/test/spoon.jpg");
				
				myhome.uploadButton.click();
				
				//check if it is uploaded or not
				assertTrue(myhome.deleteBox.isDisplayed());
				extentLogger.pass("Image uploaded");
				myhome.deleteBox.click();
				myhome.logoutLink.click();
				
				

				//clear the test
				
		
	}
	
	
	
	@Test
	public void SPA1112() {
		
		extentLogger = report.createTest("Posting Feed test");
		String message="Hello SDET150K";
		
		//go to homepage
		extentLogger.info("Going to Homepage");

		driver.get(ConfigurationReader.getProperty("url"));
		
		
		driver.findElement(By.partialLinkText("Log In")).click();
		
		//login
		login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		extentLogger.info("Loged in");

		//post the message
		myhome.newsFeedTextBox.sendKeys(message);
		extentLogger.info("Message Post");

		myhome.shareButton.click();
		
		//check if message posted or not
		assertTrue(driver.findElement(By.xpath("//*[.='"+message+"']")).isDisplayed());
		extentLogger.pass("Message Displayed");

		
		myhome.removeFeedButton.click();
		myhome.logoutLink.click();
	}
	
	
	
	
	

}
