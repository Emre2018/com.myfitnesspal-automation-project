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
import com.myfitnesspal.tests.TestBase;
import com.myfitnesspal.utilities.BrowserUtils;
import com.myfitnesspal.utilities.Driver;

public class AddExcercise extends TestBase {

	LoginPage loginPage = new LoginPage();
	ExercisePage exercisePage = new ExercisePage();

	@Ignore
	@Test(priority = 1, groups = { "smoke" })
	public void addExerciseNegativeTest() {

		driver.findElement(By.xpath("//li/a[.='Log In']")).click();
		loginPage.userName.sendKeys("rob123QW@gmail.com");
		loginPage.password.sendKeys("1qazxsw2");
		loginPage.loginButton.click();

		exercisePage.exerciseTab.click();
		exercisePage.addExercise.click();
		exercisePage.searchExercise.clear();
		exercisePage.searchExerciseButton.click();

		String expected = "Please provide a phrase to search for.";
		String actual = exercisePage.flashErrorText.getText();

		assertEquals(actual, expected);
	}

	@Test(priority = 1, groups = { "smoke" })
	public void addExercisePositiveTest() {

		driver.findElement(By.xpath("//li/a[.='Log In']")).click();
		loginPage.userName.sendKeys("rob123QW@gmail.com");
		loginPage.password.sendKeys("1qazxsw2");
		loginPage.loginButton.click();

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
		
		
	}

}
