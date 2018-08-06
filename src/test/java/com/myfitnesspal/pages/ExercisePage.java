package com.myfitnesspal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myfitnesspal.utilities.Driver;

public class ExercisePage {

public ExercisePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(linkText="EXERCISE")
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
