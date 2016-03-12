import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DragAndDrop {
	
public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.mobeta.android.demodslv:id/activity_title")).click();
		System.out.println(driver.findElements(By.id("com.mobeta.android.demodslv:id/test_bed")).size());
		System.out.println(driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).size());
		
		new TouchAction((MobileDriver)driver).longPress((WebElement) driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(0)).moveTo((WebElement) driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(3)).release().perform();
		
		driver.quit();
	}

}
