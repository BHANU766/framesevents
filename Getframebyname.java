package com.framesevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Getframebyname {

	   protected static String url="https://www.tutorialspoint.com/selenium/practice/nestedframes.php";
	   WebDriver driver;

@BeforeSuite 
public void startchromebrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
}	

@BeforeClass
public void openurl() {
	  driver.get(url);
}

@Test
public void framebyname() {
	driver.switchTo().frame("frame1");
	WebElement frametext=driver.findElement(By.xpath("//*[starts-with(text(),'Selenium -')]"));
	System.out.println(frametext.getText());
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}

}
