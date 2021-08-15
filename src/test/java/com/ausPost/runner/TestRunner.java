package com.ausPost.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


@CucumberOptions(tags = {"@smoke"}, glue = {"com.ausPost.stepdefs"}, plugin = {"html:target/cucumber-reports/HomePage/cucumber-pretty", "json:target/json-cucumber-reports/homepage/cukejson.json",
        "testng:target/testng-cucumber-reports/HomePage/cuketestng.xml"}, features = {"src/test/resources/features/ausPost/"})
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void before() {
        System.out.println("Before - " + System.currentTimeMillis());
    }

    @AfterClass
    public static void after() {
        System.out.println("After - " + System.currentTimeMillis());
    }
}
