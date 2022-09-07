package com.appiumFramework;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

public class SimpleAndroidCalcTest{	
static AndroidDriver<AndroidElement> driver;

 @BeforeTest
 public void setUp() throws MalformedURLException 
 {  
  DesiredCapabilities capabilities = new DesiredCapabilities(); 
capabilities.setCapability("deviceName","moto g(7)");
capabilities.setCapability("udid", "ZF6224BG9B");  
capabilities.setCapability(CapabilityType.VERSION, "10");  
capabilities.setCapability("platformName", "Android");  
capabilities.setCapability("appPackage", "com.google.android.calculator");  
capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); 
  //driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  driver = new AndroidDriver<AndroidElement>(capabilities);
}
 @Test
 public void Sum()
 {
  ((RemoteWebElement) driver.findElements(By.xpath("//android.widget.Button")).get(0)).click();
  driver.findElement(By.name("2")).click();
  driver.findElement(By.name("+")).click();
  driver.findElement(By.name("5")).click();
  driver.findElement(By.name("=")).click();
  String result = driver.findElement(By.className("android.widget.EditText")).getText();
  System.out.println("Number sum result is : " + result);
 }

 /*
public static AndroidDriver<MobileElement> driver =null;
public static AppiumDriverLocalService service =null;
public static void main(String[] args) {

service = AppiumDriverLocalService.buildDefaultService();

DesiredCapabilities capabilities = new DesiredCapabilities();  
/*capabilities.setCapability("deviceName","GT-S5282");
capabilities.setCapability("udid", "19761202");  
capabilities.setCapability(CapabilityType.VERSION, "4.1.2");  
capabilities.setCapability("platformName", "Android");  
capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");  
capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator"); 

capabilities.setCapability("deviceName","moto g(7)");
capabilities.setCapability("udid", "ZF6224BG9B");  
capabilities.setCapability(CapabilityType.VERSION, "10");  
capabilities.setCapability("platformName", "Android");  
capabilities.setCapability("appPackage", "com.google.android.calculator");  
capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); 
service.start();
driver = new AndroidDriver<MobileElement>(service, capabilities);
//((RemoteWebElement) driver.findElements(By.xpath("com.google.android.calculator:id/formula")).get(0)).click();
System.out.println("Application Started............");
MobileElement two=driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
MobileElement add=driver.findElement(By.id("com.google.android.calculator:id/op_add"));
MobileElement five=driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
MobileElement equal=driver.findElement(By.id("com.google.android.calculator:id/eq"));
MobileElement space=driver.findElement(By.className("android.widget.TextView"));
two.click();
add.click();
five.click();
equal.click();
String result=space.getText();
System.out.println("Number sum result is : " + result);
service.stop();
driver.quit();
/*
 * 
 * 
 */
@AfterTest
 public void End() 
 {
  driver.quit();
 }
 
}

