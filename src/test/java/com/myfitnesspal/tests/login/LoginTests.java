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
	}

	@Test(priority = 2)
	public void LoginNeg() {

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

		
	}

	@Test(priority = 3)
	public void LoginNeg2() {

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

	}

	@Test(priority = 4)
	public void LoginPositive() {

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
