package com.ausPost.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static Properties prop = new Properties();
	public static WebDriver driver;



	public Driver(){
		try {
			prop.load( new FileInputStream("./config/application.properties") );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver(){
		return this.driver;
	}

	public void setDriver() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			launchChrome();
		} else if(browser.equalsIgnoreCase("firefox")){
			launchFirefox();
		}
		else {
			launchIE();
		}
		driver.get( prop.getProperty("baseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	public String getBaseUrl(){
		String url = prop.getProperty("baseUrl");
		return url;
	}

	public void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	public void launchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}
	public void launchIE() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
}
