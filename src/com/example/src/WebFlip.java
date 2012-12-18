package com.example.src;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WebFlip {
public WebDriver driver;

public WebFlip(WebDriver driver) {
    this.driver = driver; 
}


public void searchFor(CharSequence[] searchTerm) {
	
	driver.get("http://10.10.4.126:8080/thoughtconf/attendee/session/1");
	driver.findElement(By.id("username")).sendKeys("test.twu");
	driver.findElement(By.id("password")).sendKeys("Th0ughtW0rks@12");
	driver.findElement(By.name("submit")).click();
	driver.navigate().to("");
	driver.manage().deleteAllCookies();
//	driver.manage().deleteCookieNamed("JSESSIONID");
	driver.navigate().to("http://10.10.4.126:8080/thoughtconf/attendee/session/1");
//	driver.get("");

//     driver.get("http://flipkart.com");        
//    driver.findElement(By.id("fk-top-search-box")).sendKeys(searchTerm);
//    driver.findElement(By.name("Search")).click();                  
}

public static void main(String[] args){
	File profileDir = new File("C:\\Users\\jayachk\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\fltr57wl.sample");
	FirefoxProfile profile = new FirefoxProfile(profileDir);
	profile.setPreference("browser.cache.disk.enable", false);
	profile.setPreference("browser.cache.memory.enable", false);
	profile.setPreference("browser.cache.offline.enable", false);
	profile.setPreference("network.http.use-cache", false);
	WebFlip login = new WebFlip(new FirefoxDriver(profile));
    login.searchFor(new String[] {"Agile samurai"});
}
}