package com.myfitnesspal.tests.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	MyHomePage loginpage = new MyHomePage();

	@Test(priority = 1)
	public void getTitle() {
		extentLogger = report.createTest("Verify title is correct");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Free Calorie Counter, Diet & Exercise Journal | MyFitnessPal.com";
		assertEquals(expectedTitle, actualTitle);
		
		extentLogger.pass("Verifies title is correct");
	}

	@Test(priority = 2)
	public void LoginNeg() {
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
	
	}

	@Test(priority = 3)
	public void LoginNeg2() {
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
	}

	@Test(priority = 4)
	public void LoginPositive() {
		extentLogger = report.createTest("Positive login test");
		
		extentLogger.info("click login");
		loginpage.logIn.click();
		
		extentLogger.info("send username=rob123QW@gmail.com, password=1qazxsw2");
		loginpage.userName.sendKeys("rob123QW@gmail.com");
		loginpage.password.sendKeys("1qazxsw2");
		loginpage.loginButton.click();
		
		extentLogger.pass("Verifies positive login test is passed");
	}

	@Test(priority = 5)
	public void logoutTest() {

		extentLogger = report.createTest("Positive logout test");
		extentLogger.info("click log out");

		String expected = loginPage.logout.getText();
		assertTrue(expected.equals("Log Out"));
		extentLogger.info("Verifying log out link");
		// pass --> message that tells us what passed
		extentLogger.pass("Verifies log out link displayed");

	}

}
