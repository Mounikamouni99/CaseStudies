package com.qa.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.BaseTest.BaseTest;
import com.qa.Utilities.ExcelUtility;
import com.qa.pages.Pages;

public class TestCase1 extends BaseTest {
	@Test(dataProvider = "getData")
	public void SearchTest(String inp) throws InterruptedException {
		Pages page = new Pages(driver);
		page.getSearchBox().clear();
		page.getSearchBox().sendKeys(inp, Keys.ENTER);
		Thread.sleep(2000);
		boolean noData;
		try {
			page.getIsNoResult().isDisplayed();
			noData = true;
		} catch (NoSuchElementException e) {
			noData = false;
		}
		if (noData) {
			Reporter.log("No Item Found", true);

		} else {
			List<WebElement> results = page.getSearchResults();
			System.out.println(results);
			String title;
			String price;
			for (WebElement result : results) {
				title = result.findElement(By.tagName("strong")).getText();
				price = result.findElement(By.className("price")).getText();
				Reporter.log("price of " + title + " : " + price, true);

			}
		}

	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\yamin\\eclipse-workspace\\CromaTC\\src\\test\\java\\com\\qa\\Utilities\\TestData .xlsx";
		String sheet = "Sheet1";
		int rowCount = ExcelUtility.getRowCount(path, sheet);
		int cellCount = ExcelUtility.getCellCount(path, sheet, rowCount);
		String[][] data = new String[rowCount][cellCount];
		for  (int i = 1; i<= rowCount; i++) {
			for(int j = 0; j< cellCount ; j++) {
				data[i-1][j] =  ExcelUtility.getCellData(path, sheet, i, j);
			}

			
		}
		
		return data;
	}

}
