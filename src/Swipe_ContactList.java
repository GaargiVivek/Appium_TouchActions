import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Swipe_ContactList {
public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.google.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		//driver.scrollTo("Maha").click();
		
		String str = "Maha";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+str+"\").instance(0))").click();
		/*
		 int i = 0;
		 boolean firstTime = true;
		 
		 while(true)
		 {
			 WebElement contactList = driver.findElement(By.id("android.widget.ImageView"));
			 List<WebElement> contacts = driver.findElements(By.className("android.widget.TextView"));
			 //verticalSwipe();
			 System.out.println(contacts.get(i).getText());
			 if(contacts.get(i).getText().equalsIgnoreCase("Maha"))
			 {
				 horizontalSwipe(generateY(contacts.get(i).getLocation()));
				 break;
			 }
			 
			 if(i==10)
			 {
				 if(firstTime)
				 {
					 i=0;
					 verticalSwipe();
				 }
			 }
			 
			 i++;
		 }
		 */
		 
	}
	
	public static void horizontalSwipe(double y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		HashMap<String,Double> swipeObject = new HashMap<String,Double>();
		swipeObject.put("startX", 340.00);
		swipeObject.put("startY", y);
		swipeObject.put("endX", 830.00);
		swipeObject.put("endY", y);
		swipeObject.put("duration", 1.0);
		js.executeScript("mobile: swipe", swipeObject);
		
		
	}
	
	public static void verticalSwipe()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		HashMap<String,Double> swipeObject = new HashMap<String,Double>();
		swipeObject.put("startX", 461.00);
		swipeObject.put("startY", 1639.00);
		swipeObject.put("endX", 510.00);
		swipeObject.put("endY", 610.00);
		swipeObject.put("duration", 1.0);
		js.executeScript("mobile: swipe", swipeObject);
		
		
	}
	
	public static double generateX(Point point)
	{
		int x = point.getX();
		return x;
	}
	
	public static double generateY(Point point)
	{
		int y = point.getY();
		return y;
	}

}
