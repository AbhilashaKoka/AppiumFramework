package tests;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


    public class BaseClass extends ExtentsReportDemo{
	public static AndroidDriver<MobileElement> driver =null;
	public static AppiumDriverLocalService service =null;
	
	public BaseClass() {
		// TODO Auto-generated constructor stub
	}	
	
@BeforeTest
public static void setup()  {
	try {
    service = AppiumDriverLocalService.buildDefaultService();
	DesiredCapabilities cap= new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "moto g(7)");
	cap.setCapability(MobileCapabilityType.UDID, "ZF6224BG9B");
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	cap.setCapability(MobileCapabilityType.BROWSER_NAME, "CHROME");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");	
	cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
	//driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	 service.start();
	 if(service.isRunning()==true) {
		execKill(1L);
		service.start();
	}
	//cap = { "chromeOptions" => {'w3c' => true} }
	driver = new AndroidDriver<MobileElement>(service, cap);
	
	 System.out.println("Browser Started...........");
	}
	
	    catch(Exception ex)
	    {
		System.out.println("Cause is:"+ex.getCause());
		System.out.println("Messageis:"+ex.getMessage());
		ex.printStackTrace();
		}
}

@AfterTest
public void start()
{
//service.stop();
driver.quit();
System.out.println("Browser is Closed..........");

}

public static void execKill(long minutes)throws InterruptedException{
	try {
		Thread.sleep(minutes*60L*1000L);
		Runtime.getRuntime().exec("cmd /c  TASKKILL /F /IM node.exe");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

