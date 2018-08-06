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
	MyHomePage loginpage = new MyHomePage(driver);
	
	@Test(priority = 1)
	public void getTitile() {
		//driver.get("https://www.myfitnesspal.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Free Calorie Counter, Diet & Exercise Journal | MyFitnessPal.com";
		assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 2)
	public void LoginNeg() {
		//driver.get("https://www.myfitnesspal.com/");
		
		loginpage.logIn.click();
		loginpage.userName.sendKeys("rob123QW@gmail.com");
		loginpage.password.sendKeys("invalid");
		loginpage.loginButton.click();
		String errorMsg = loginpage.invalidUserNameErrMsg.getText();
		assertEquals(errorMsg, "Incorrect username or password. Please try again.");
	}

	@Test(priority = 3)
	public void LoginNeg2() {
		//driver.get("https://www.myfitnesspal.com/");
		
		loginpage.logIn.click();
		loginpage.userName.sendKeys("invalid");
		loginpage.password.sendKeys("1qazxsw2");
		loginpage.loginButton.click();
		String errorMsg = loginpage.invalidUserNameErrMsg.getText();
		assertEquals(errorMsg, "Incorrect username or password. Please try again.");
	}

	@Test(priority = 4)
	public void LoginPositive() {
		//driver.get("https://www.myfitnesspal.com/");
		loginpage.logIn.click();
		loginpage.userName.sendKeys("rob123QW@gmail.com");
		loginpage.password.sendKeys("1qazxsw2");
		loginpage.loginButton.click();

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
