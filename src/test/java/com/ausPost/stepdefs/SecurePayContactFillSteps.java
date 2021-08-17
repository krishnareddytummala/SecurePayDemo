package com.ausPost.stepdefs;

import com.ausPost.common.Driver;
import com.ausPost.common.ExtentReportListener;
import com.ausPost.pages.BasePage;
import com.ausPost.pages.GoogleSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ausPost.pages.SecurePayContactPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;


public class SecurePayContactFillSteps extends ExtentReportListener {

    SecurePayContactPage securePayContactPage = new SecurePayContactPage(driver);
    GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

    @Given("Searches for SecurePay on google")
    public void searches_for_SecurePay_on_google() {
        googleSearchPage.searchSecurePay();
    }

    @When("Clicks through to the SecurePay website")
    public void clicks_through_to_the_SecurePay_website() {
        googleSearchPage.clickSecurePayWebsite();
    }

    @Then("Navigates to the contact us page")
    public void navigates_to_the_contact_us_page() {
        securePayContactPage.clickContactUs();

    }

    @Then("Verifies that the contact us page is loaded")
    public void verifies_that_the_contact_us_page_is_loaded() {
        Assert.assertTrue(securePayContactPage.isSecurePayContactPageDisplayed());
    }

    @Then("Uses the random generated data to fill in the contact us form")
    public void uses_the_random_generated_data_to_fill_in_the_contact_us_form() {
        securePayContactPage.fillContactForm();
    }

}
