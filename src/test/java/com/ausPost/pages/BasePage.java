package com.ausPost.pages;

import com.ausPost.common.Driver;
import com.ausPost.common.ExtentReportListener;
import com.ausPost.utilities.RandomUtils;
import io.cucumber.java.de.Wenn;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage extends ExtentReportListener {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

	public void clickElement(WebElement element, String elementName){
		try {
			element.click();
		}
		catch(NoSuchElementException e){

		}

	}

	public void type(WebElement element, String textToType, String elementName){
		try {
			element.clear();
			element.sendKeys(textToType);
		}
		catch(NoSuchElementException e){

		}

	}

	public boolean isElementDisplayed(WebElement element){
		try {
			element.isDisplayed();
			return true;
		}catch (NoSuchElementException e){
			return  false;
		}

	}

	public void selectValueFromDropdownByIndex(WebElement element){
		try {
			Select ddn = new Select(element);
			ddn.selectByIndex(2);
		}
		catch (NoSuchElementException e){
			e.printStackTrace();
		}


	}


}
