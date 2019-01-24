package utilities;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class MyUtils {

	public static void rightLeftSwipe(AppiumDriver driver) {

		// No Unique classnames available in the apk
		Dimension windowSize = driver.manage().window().getSize();

		// Performing gesture tap action
		int startX = windowSize.getWidth() - 200;
		int startY = 500;
		PointOption stratPoint = point(startX, startY);

		int endX = 200;
		int endY = 500;
		PointOption endPoint = point(endX, endY);
		// System.out.println(windowSize);

		TouchAction touchaction = new TouchAction(driver);
		touchaction.press(stratPoint);
		touchaction.waitAction();
		touchaction.moveTo(endPoint);
		touchaction.release();
		touchaction.perform();
	}

	public static void scrollDown(AndroidDriver driver) throws Exception {

		// The viewing size of the device
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;
		int startY = 100;
		PointOption stratPoint = point(startX, startY);

		int endX = startX;
		int endY = size.height - 2;
		PointOption endPoint = point(endX, endY);

		TouchAction touchaction = new TouchAction(driver);
		touchaction.press(stratPoint);
		touchaction.waitAction();
		touchaction.moveTo(endPoint);
		touchaction.release();
		touchaction.perform();
	}
	
	public static void scrollUp(AppiumDriver driver) throws Exception {

		// The viewing size of the device
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;
		int startY = size.height - 300;
		PointOption stratPoint = point(startX, startY);

		int endX = size.width / 2;
		int endY = 200;
		PointOption endPoint = point(endX, endY);
		
		TouchAction touchaction = new TouchAction(driver);
		touchaction.press(stratPoint);
		touchaction.waitAction();
		touchaction.moveTo(endPoint);
		touchaction.release();
		touchaction.perform();
	}
}
