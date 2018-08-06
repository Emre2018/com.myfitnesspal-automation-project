package com.myfitnesspal.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.myfitnesspal.utilities.*;

public class ExercisePage {

public ExercisePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="ember1431")
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
