package com.myfitnesspal.pages;

<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myfitnesspal.utilities.Driver;
=======
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.myfitnesspal.utilities.*;
>>>>>>> 9785c408a1d903fc93119b99aa60acd6523a11fd

public class ExercisePage {

public ExercisePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
<<<<<<< HEAD
	
	@FindBy(linkText="EXERCISE")
=======

@FindBy(xpath="//i[@id='datepicker-trigger']")
public WebElement calendar;

@FindBy(xpath="//div[@class='diary']//span/time")
public WebElement calendarDate;

//   


	@FindBy(id="ember1431")
>>>>>>> 9785c408a1d903fc93119b99aa60acd6523a11fd
	public WebElement exerciseTab;
	
	@FindBy(linkText="Add Exercise")
	public WebElement addExercise;
	
	@FindBy(id="search")
	public WebElement searchExercise;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement searchExerciseButton;
	
	@FindBy(xpath="//p[@class='flash']")
	public WebElement flashErrorText;
	
	@FindBy(xpath="(//ul[@id='matching']//a[contains(.,'Run')])[3]")
	public WebElement matchingResult;
	
	@FindBy(id="exercise_entry_quantity")
	public WebElement entryQuantity;
	
	@FindBy(id="update_exercise")
	public WebElement updateExercise;
	
	@FindBy(id="exercise_entry_calories")
	public WebElement entryCalory;
	
	@FindBy(xpath="//table[@class='table0']//tbody/tr/td[3]")
	public WebElement tableCalory;

}
