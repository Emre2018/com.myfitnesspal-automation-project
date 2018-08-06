package com.myfitnesspal.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.myfitnesspal.pages.ExercisePage;
import com.myfitnesspal.pages.LoginPage;
import com.myfitnesspal.pages.MyHomePage;

public class TestExercise extends TestBase{
//	HomePage homePage= new HomePage();
	MyHomePage myHomePage= new MyHomePage();
  LoginPage loginPage= new LoginPage();
  ExercisePage exercisePage = new  ExercisePage();
  




@Test
public void testExerciseLink(){
	//homePage.logIn.click();
	extentLogger = report.createTest("Test Exercise Link");
	extentLogger.info("Going to Homepage");
	loginPage.logIn.click();
	loginPage.login("rob123QW@gmail.com", "1qazxsw2" );
	extentLogger.info("Loged in");
	myHomePage.exerciseLink.click();
	
	assertTrue(driver.getTitle().contains("Exercise Diary"));
	
	extentLogger.info("Verified Title");
	extentLogger.pass("Verifies title displayed");
	myHomePage.logout.click();
}


@Test
public void testAddExerciseButton(){
	extentLogger = report.createTest("Test Add Exercise Button");
	extentLogger.info("Going to Homepage");
	loginPage.logIn.click();
	loginPage.login("rob123QW@gmail.com", "1qazxsw2" );
	extentLogger.info("Loged in");
	myHomePage.addExerciseButton.click();
	
	assertTrue(driver.getTitle().contains("Exercise Diary"));
	extentLogger.info("Verified Title");
	extentLogger.pass("Verifies title displayed");
	myHomePage.logout.click();
} 

	 @Test
	 public void testExerciseCalendar(){
		 extentLogger = report.createTest("Test Exercise Calendar");
		 extentLogger.info("Going to Homepage");
		 loginPage.logIn.click();
		loginPage.login("rob123QW@gmail.com", "1qazxsw2" );
		extentLogger.info("Loged in");
		myHomePage.addExerciseButton.click();
		exercisePage.calendar.click();
		
	
	 }


}
