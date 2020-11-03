package test;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeDemo extends Base{
	public static void main(String[] args) throws MalformedURLException{
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@Text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@Text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

		//Long Press and SWIPE action to move and set clock from 9:15 to 9:45
		driver.findElementByXPath("//*[@content-desc='9']").click();
		TouchAction t = new TouchAction(driver);
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
		//long press on element for 1sec and move to another element and release
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		
	}
}
