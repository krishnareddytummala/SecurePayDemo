package com.ausPost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends BasePage {

    @FindBy(xpath = "//input[@title='Search']")
    @CacheLookup
    WebElement txtSearchGoogle;

    @FindBy(xpath = "(//div//input[@name='btnK'])[2]")
    @CacheLookup
    WebElement btnGoogleSearch;

    @FindBy(xpath = "//h3[contains(text(),'SecurePay | Trusted Online Payment Gateway Provider in ...')]")
    @CacheLookup
    WebElement securePayWebsite;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void searchSecurePay() {
        type(txtSearchGoogle, "Secure Pay");
        clickElement(btnGoogleSearch);
    }

    public void clickSecurePayWebsite() {
        clickElement(securePayWebsite);
    }
}
