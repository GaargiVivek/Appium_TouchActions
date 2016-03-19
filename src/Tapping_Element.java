import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Tapping_Element {
	
	public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.Main");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
		driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("Arunn Krishnamurthy");
		
		TouchAction action = new TouchAction((MobileDriver)driver);
		action.tap(445, 295).perform();
		
		driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("This is Appium Test again! :D");
		driver.findElement(By.id("com.whatsapp:id/send")).click();
		
		driver.findElement(By.id("com.whatsapp:id/camera_btn")).click();
		driver.findElement(By.id("com.whatsapp:id/shutter")).click();
		driver.findElement(By.id("com.whatsapp:id/caption")).sendKeys("This is banana ;D");
		driver.findElement(By.id("com.whatsapp:id/ok")).click();
		
		driver.quit();
	}
	

}
