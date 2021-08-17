package com.ausPost.pages;

import com.ausPost.utilities.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePayContactPage extends BasePage {

    public SecurePayContactPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Contact us')]")
    @CacheLookup
    WebElement btnContactUs;

    @FindBy(xpath = "//h1[contains(text(),'Contact our Sales Team')]")
    @CacheLookup
    WebElement hdrContact;

    @FindBy(xpath = "//input[@name='firstName']")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(xpath = "//input[@name='email']")
    @CacheLookup
    WebElement txtWorkEmail;

    @FindBy(xpath = "//input[@name='phone']")
    @CacheLookup
    WebElement txtPhoneNumber;

    @FindBy(xpath = "//input[@name='company']")
    @CacheLookup
    WebElement txtCompanyName;

    @FindBy(xpath = "//input[@name='website']")
    @CacheLookup
    WebElement txtWebsiteURL;

    @FindBy(xpath = "//select[@name='amount']")
    @CacheLookup
    WebElement dropdownAmount;

    @FindBy(xpath = "//textarea[@name='message']")
    @CacheLookup
    WebElement txtMessage;

    public void clickContactUs() {
        clickElement(btnContactUs);
    }

    public boolean isSecurePayContactPageDisplayed() {
        return isElementDisplayed(hdrContact);
    }

    public void fillContactForm() {
        try {
            type(txtFirstName, RandomUtils.getRandomString(5));
            type(txtLastName, RandomUtils.getRandomString(5));
            type(txtWorkEmail, RandomUtils.getRandomEmail(7));
            type(txtCompanyName, RandomUtils.getRandomString(5));
            txtWebsiteURL.sendKeys(RandomUtils.getRandomWebSite(6));
            type(txtWebsiteURL, RandomUtils.getRandomWebSite(6));
            type(txtMessage, RandomUtils.getRandomString(10));
            selectValueFromDropdownByIndex(dropdownAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
