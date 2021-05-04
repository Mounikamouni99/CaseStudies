package com.qa.pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBox;

	@FindAll(@FindBy(xpath = "//body/div[1]/div[1]/div[1]/main[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li/div[1]"))
	List <WebElement> searchResults;
	
	
	@FindBy(xpath = "//div[contains(text(),'Your search returned no results.')]")
	WebElement noResult;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public List <WebElement> getSearchResults() {
		return searchResults;
	}
	
	public WebElement getIsNoResult() {
		return noResult;
	}

	public Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
