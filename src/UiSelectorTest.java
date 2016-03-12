import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UiSelectorTest {
	
public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException
	{

		File app = new File("E:\\Selendroid App\\selendroid-test-app-0.10.0.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app",app.getAbsolutePath());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Display Popup Window')]")).click();
		
		//To click on the button using UiSelector() class
		//driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Display Popup Window\")").click();
		
		//Locate the element that is already checked "checkbox"
		//driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.CheckBox\").checked(true)").click();
		
		//To click on the element using index
	   /* System.out.println(driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.Button\").index(1)").size());
	    
	     driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.LinearLayout\").className(\"android.widget.Button\").index(1)").get(1); */
		
		WebDriverWait wait = new WebDriverWait(driver, 2L);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("io.selendroid.testapp:id/visibleButtonTest")));//.click() not working????
		driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest")).click();
		
		driver.quit();
	}

}
