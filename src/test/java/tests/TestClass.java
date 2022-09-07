package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class TestClass extends BaseClass{		
	ExtentTest test1, test2;
	
	    @Test
	     public void searchgooglepage() {
		   test1 = extent.createTest("MyFirstTest", "Test to search using google");
	       test1.log(Status.INFO, "Test one started");
	       test1.info("This step shows usage of info(details)");
	       driver.get("https://www.google.com");
	       test1.log(Status.PASS,"Navigated to google site");
	       driver.findElement(By.name("q")).sendKeys("Automation");
		   test1.log(Status.PASS,"Enter Automation in the search box");
		   driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		   test1.log(Status.PASS,"Hit enter Key");
		   System.out.println("Test Completed...........");
		   test1.log(Status.INFO,"Test one completed.......");
	}

	    
	      @Test
	       public void loginTest() {	
		    test2 = extent.createTest("MySecondTest", "/login to orangeHRM");
	        test2.log(Status.INFO, "Test one started");	       
		    driver.get("https://opensource-demo.orangehrmlive.com/");
		    test2.log(Status.PASS,"Navigate to  https://opensource-demo.orangehrmlive.com/");
		    driver.findElement(By.xpath("//div[@id='divUsername']/span")).click();
		    driver.findElement(By.id("txtUsername")).clear();
		    test2.log(Status.PASS, "Clear the textbox");
		    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		    test2.log(Status.PASS, "Enter the username");
		    driver.findElement(By.id("txtPassword")).clear();
		    test2.log(Status.PASS, "Clear the textbox");
		    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		    test2.log(Status.PASS, "Enter the pasword");
		    driver.findElement(By.id("btnLogin")).click();
		    test2.log(Status.PASS, "Click on the login");
		    System.out.println("Test COmpleted.........");
		    test2.log(Status.INFO,"Test one completed.......");
	}
}
