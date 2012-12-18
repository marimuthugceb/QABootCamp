package com.example.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {
	
  @BeforeMethod
  public void before(){
	  System.out.println("before method");
  }
  
  @BeforeTest
  public void before2(){
	  System.out.println("before test");
  }  
	
  @Test
  public void f() {
	  System.out.println("test 1");
	  Assert.assertEquals(true, true);
  }
	
  @Test
  public void f2() {
	  System.out.println("test 2");
	  Assert.assertEquals(true, true);
  }
  
  @Test
  public void sel(){
	  WebDriver wd = new FirefoxDriver();
	  wd.get("http://www.flipkart.com");
  }
	
  @AfterMethod
  public void after(){
	  System.out.println("after method");
  }
  
  @AfterTest
  public void after2(){
	  System.out.println("after test");
  }  
  
  
}
