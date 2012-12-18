package com.example.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebD {
public WebDriver driver;

public WebD(WebDriver driver) {
    this.driver = driver; 
}


public void searchFor(CharSequence[] searchTerm) throws IOException {
	
	Properties pro = new Properties();
	FileInputStream in = new FileInputStream("prop.properties");
	pro.load(in);
	
	driver.get(pro.getProperty("URL"));
	 WebElement myDynamicElement = (new WebDriverWait(driver, 10))
	    .until(new ExpectedCondition<WebElement>(){
	  	@Override
	  	public WebElement apply(WebDriver d) {
	  		return d.findElement(By.linkText("LOG IN"));
	  	}});
	driver.findElement(By.linkText("LOG IN")).click();

	 WebElement myDynamicElement2 = (new WebDriverWait(driver, 10))
	    .until(new ExpectedCondition<WebElement>(){
	  	@Override
	  	public WebElement apply(WebDriver d) {
	  		return d.findElement(By.id("facebookLoginButton"));
	  	}});
	driver.findElement(By.id("facebookLoginButton")).click();
//	driver.findElement(By.linkText("Check In")).click();

//     driver.get("http://flipkart.com");        
//    driver.findElement(By.id("fk-top-search-box")).sendKeys(searchTerm);
//    driver.findElement(By.name("Search")).click();                  
}

public static void main(String[] args){
	File profileDir = new File("C:\\Users\\jayachk\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\fltr57wl.sample");
	FirefoxProfile profile = new FirefoxProfile(profileDir);
	
//	FirefoxDriver driver = new FirefoxDriver(profile);
	
    WebD web = new WebD(new FirefoxDriver(profile));
    try {
		web.searchFor(new String[] {"Agile samurai"});
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}