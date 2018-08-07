package com.myfitnesspal.tests.exercise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.myfitnesspal.pages.ExercisePage;
import com.myfitnesspal.pages.LoginPage;
import com.myfitnesspal.pages.MyHomePage;
import com.myfitnesspal.tests.TestBase;
import com.myfitnesspal.utilities.BrowserUtils;
import com.myfitnesspal.utilities.Driver;

public class AddExcercise extends TestBase {

	LoginPage loginPage = new LoginPage();
	ExercisePage exercisePage = new ExercisePage();
	MyHomePage myHomePage= new MyHomePage();


	@Test()
	public void addExerciseNegativeTest() {
		extentLogger = report.createTest("Verify negative add exercise test");
		extentLogger.info("Logging in the website with valid credentials");
		
		driver.findElement(By.xpath("//li/a[.='Log In']")).click();
		
		loginPage.userName.sendKeys("rob123QW@gmail.com");
		loginPage.password.sendKeys("1qazxsw2");
		loginPage.loginButton.click();

		extentLogger.info("Clicking exercise tab and searching exercise without sending anything");
		BrowserUtils.waitForClickablility(exercisePage.exerciseTab, 10);
		exercisePage.exerciseTab.click();
		exercisePage.addExercise.click();
		exercisePage.searchExercise.clear();
		exercisePage.searchExerciseButton.click();

		String expected = "Please provide a phrase to search for.";
		String actual = exercisePage.flashErrorText.getText();

		assertEquals(actual, expected);
		
		extentLogger.pass("Verifies negative add exercise test is passed");
		myHomePage.logout.click();
		
	
	}

	@Test()
	public void addExercisePositiveTest() {
		extentLogger = report.createTest("Verify negative add exercise test");
		
		extentLogger.info("Logging in the website with valid credentials");
				
//		driver.findElement(By.xpath("//li/a[.='Log In']")).click();
//		loginPage.userName.sendKeys("rob123QW@gmail.com");
//		loginPage.password.sendKeys("1qazxsw2");
//		loginPage.loginButton.click();
		
		loginPage.logIn.click();
		loginPage.login("rob123QW@gmail.com","1qazxsw2" );

		extentLogger.info("Clicking exercise tab and searching exercise with the keyword 'run'");
		BrowserUtils.waitForClickablility(exercisePage.exerciseTab, 10);
		exercisePage.exerciseTab.click();
		exercisePage.addExercise.click();
		exercisePage.searchExercise.clear();
		exercisePage.searchExercise.sendKeys("run");
		exercisePage.searchExerciseButton.click();

//		List<WebElement> matching = Driver.getDriver().findElements(By.xpath("//ul[@id='matching']//a[contains(.,'Run')]"));
//		List<String> expectedResult = new ArrayList<>();
//		for (WebElement matchRes : matching) {
//			if(matchRes.getText().contains("Run")) {
//			expectedResult.add(matchRes.getText());
//			}
//		}

//		System.out.println(expectedResult);
		
		assertTrue(exercisePage.matchingResult.getText().contains("Run"));
		
		exercisePage.matchingResult.click();
		BrowserUtils.waitForVisibility(exercisePage.entryQuantity, 10);
		exercisePage.entryQuantity.sendKeys("20");
		
		BrowserUtils.waitForVisibility(exercisePage.entryCalory, 10);
		String caloriesBurnExpected = exercisePage.entryCalory.getAttribute("value");
		
		exercisePage.updateExercise.click();
		
		String caloriesBurnActual = exercisePage.tableCalory.getText();
		
		assertEquals(caloriesBurnActual, caloriesBurnExpected);
		
		extentLogger.pass("Verifies positive add exercise test is passed");
		myHomePage.logout.click();
	}

}
