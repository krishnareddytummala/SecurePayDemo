package com.ausPost.pages;

import com.ausPost.common.ExtentReportListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class BasePage extends ExtentReportListener {

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
        }
    }

    public void type(WebElement element, String textToType) {
        try {
            element.clear();
            element.sendKeys(textToType);
        } catch (NoSuchElementException e) {
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void selectValueFromDropdownByIndex(WebElement element) {
        try {
            Select ddn = new Select(element);
            ddn.selectByIndex(2);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
