package test;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Uiautomatortest extends Base {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Syntax: driver.findElementByAndroidUIAutomator("attribute("value")")
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//Validate clickable property for all options
		//Syntax: driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)")
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());	
	}
}
