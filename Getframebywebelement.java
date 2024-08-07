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

public class Getframebywebelement {

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
public void framebywebelement() {
	WebElement frametext=driver.findElement(By.id("frame1"));
	driver.switchTo().frame(frametext);  //webelement to frame as text
	WebElement iframetext=driver.findElement(By.xpath("//*[starts-with(text(),'Selenium -')]"));
	System.out.println(iframetext.getText());
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
