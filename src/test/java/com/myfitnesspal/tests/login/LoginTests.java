package com.myfitnesspal.tests.login;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.myfitnesspal.pages.LoginPage;
import com.myfitnesspal.pages.MyHomePage;
import com.myfitnesspal.tests.TestBase;
import com.myfitnesspal.utilities.ConfigurationReader;

public class LoginTests extends TestBase {
<<<<<<< HEAD
	LoginPage loginPage = new LoginPage();
	MyHomePage myHomePage = new MyHomePage();

	@Test(priority = 1)
	public void getTitile() {
		// driver.get("https://www.myfitnesspal.com/");
		extentLogger = report.createTest("Verify Title");
		// go to homepage
		extentLogger.info("Going to FitnessPal website");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Free Calorie Counter, Diet & Exercise Journal | MyFitnessPal.com";
		assertEquals(expectedTitle, actualTitle);
		extentLogger.pass("Title is matching");

=======
<<<<<<< HEAD
	LoginPage loginPage = new LoginPage();
	MyHomePage loginpage = new MyHomePage();

=======
LoginPage loginPage = new LoginPage();
	MyHomePage loginpage = new MyHomePage();
	
>>>>>>> 9785c408a1d903fc93119b99aa60acd6523a11fd
	@Test(priority = 1)
	public void getTitle() {
		extentLogger = report.createTest("Verify title is correct");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Free Calorie Counter, Diet & Exercise Journal | MyFitnessPal.com";
		assertEquals(expectedTitle, actualTitle);
		
		extentLogger.pass("Verifies title is correct");
>>>>>>> 3b963cc0fe044e0b24f38b2bc04118a623c1d377
	}

	@Test(priority = 2)
	public void LoginNeg() {
<<<<<<< HEAD
		// driver.get("https://www.myfitnesspal.com/");
		extentLogger = report.createTest("Verify Error Message after sending invalid pasword");
		extentLogger.info("Going to Login Page");
		loginPage.logIn.click();
		loginPage.userName.sendKeys("rob123QW@gmail.com");
		extentLogger.info("Sending invalid pasword");
		loginPage.password.sendKeys("invalid");
		loginPage.loginButton.click();

		String errorMsg = loginPage.invalidUserNameErrMsg.getText();
		assertEquals(errorMsg, "Incorrect username or password. Please try again.");
		extentLogger.pass("Verify error message is displayed");
=======
		extentLogger = report.createTest("Negative login test");

		extentLogger.info("click login");
		loginpage.logIn.click();
		
		extentLogger.info("send username=rob123QW@gmail.com, password=invalid");
		loginpage.userName.sendKeys("rob123QW@gmail.com");
		loginpage.password.sendKeys("invalid");
		loginpage.loginButton.click();
		String errorMsg = loginpage.invalidUserNameErrMsg.getText();
		assertEquals(errorMsg, "Incorrect username or password. Please try again.");
		
		extentLogger.pass("Verifies negative login test is passed");
	
>>>>>>> 3b963cc0fe044e0b24f38b2bc04118a623c1d377
	}

	@Test(priority = 3)
	public void LoginNeg2() {
<<<<<<< HEAD
		// driver.get("https://www.myfitnesspal.com/");
		extentLogger = report.createTest("Verify Error Message after sending invalid username");
		extentLogger.info("Going to Login Page");
		loginPage.logIn.click();
		extentLogger.info("Sending invalid username");
		loginPage.userName.sendKeys("invalid");
		loginPage.password.sendKeys("1qazxsw2");
		loginPage.loginButton.click();
		String errorMsg = loginPage.invalidUserNameErrMsg.getText();
		assertEquals(errorMsg, "Incorrect username or password. Please try again.");
		extentLogger.pass("Verify error message is displayed");
=======
		extentLogger = report.createTest("Negative login test 2");

		extentLogger.info("click login");
		loginpage.logIn.click();
		
		extentLogger.info("send username=invalid, password=1qazxsw2");
		loginpage.userName.sendKeys("invalid");
		loginpage.password.sendKeys("1qazxsw2");
		loginpage.loginButton.click();
		String errorMsg = loginpage.invalidUserNameErrMsg.getText();
		assertEquals(errorMsg, "Incorrect username or password. Please try again.");
		
		extentLogger.pass("Verifies negative login test 2 is passed");
>>>>>>> 3b963cc0fe044e0b24f38b2bc04118a623c1d377
	}

	@Test(priority = 4)
	public void LoginPositive() {
<<<<<<< HEAD
		extentLogger = report.createTest("Positive Login Test");
		// driver.get("https://www.myfitnesspal.com/");
		extentLogger.info("Going to Login Page");
		loginPage.logIn.click();
		extentLogger.info("Sending valid username and password");
		loginPage.userName.sendKeys("rob123QW@gmail.com");
		loginPage.password.sendKeys("1qazxsw2");
		loginPage.loginButton.click();
		String HiMessage = "Hi, rob123QW";
System.out.println(myHomePage.hiusermsg.getText());
		assertTrue(myHomePage.hiusermsg.getText().contains("Hi, rob123QW"));
		extentLogger.pass("Verify Hi username is displayed");
		myHomePage.logout.click();
=======
		extentLogger = report.createTest("Positive login test");
		
		extentLogger.info("click login");
		loginpage.logIn.click();
		
		extentLogger.info("send username=rob123QW@gmail.com, password=1qazxsw2");
		loginpage.userName.sendKeys("rob123QW@gmail.com");
		loginpage.password.sendKeys("1qazxsw2");
		loginpage.loginButton.click();
		
		extentLogger.pass("Verifies positive login test is passed");
>>>>>>> 3b963cc0fe044e0b24f38b2bc04118a623c1d377
	}

	@Test(priority = 5)
	public void logoutTest() {

		extentLogger = report.createTest("Positive logout test");
		extentLogger.info("Going to Login Page ");
		loginPage.logIn.click();
		loginPage.login("rob123QW@gmail.com", "1qazxsw2" );
		extentLogger.info("Loged in");
		String expected = loginPage.logout.getText();
		assertTrue(expected.equals("Log Out"));
		extentLogger.info("Verifying log out link");
		// pass --> message that tells us what passed
		extentLogger.pass("Verifies log out link is displayed");
		myHomePage.logout.click();
	}

}
