import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WhatsApp_KeyEvents {
	
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
		
		List<WebElement> contacts = driver.findElements(By.id("com.whatsapp:id/conversations_row_contact_name"));
		contacts.get(6).click();
		driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("This is Appium Test :)");
		driver.sendKeyEvent(AndroidKeyCode.ENTER);
		driver.sendKeyEvent(AndroidKeyCode.ENTER);
		driver.sendKeyEvent(AndroidKeyCode.BACKSPACE);
		driver.sendKeyEvent(AndroidKeyCode.BACKSPACE);
		driver.findElement(By.id("com.whatsapp:id/send")).click();
		
		driver.quit();
		
		
	}

}
