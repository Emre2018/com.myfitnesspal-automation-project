package com.myfitnesspal.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.myfitnesspal.pages.LoginPage;
import com.myfitnesspal.pages.MyHomePage;

public class TestExercise extends TestBase{
//	HomePage homePage= new HomePage();
	MyHomePage myHomePage= new MyHomePage();
  LoginPage loginPage= new LoginPage();




@Test
public void testExerciseLink(){
	//homePage.logIn.click();
	loginPage.logIn.click();
	loginPage.login("rob123QW@gmail.com", "1qazxsw2" );
	myHomePage.exerciseLink.click();
	assertTrue(driver.getTitle().contains("Exercise Diary"));

}


@Test
public void testAddExerciseButton(){
	loginPage.logIn.click();
	loginPage.login("rob123QW@gmail.com", "1qazxsw2" );
	myHomePage.addExerciseButton.click();
	assertTrue(driver.getTitle().contains("Exercise Diary"));
} 

}
