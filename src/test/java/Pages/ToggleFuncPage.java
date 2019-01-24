package Pages;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.List;

import org.testng.Assert;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ToggleFuncPage extends BasePage {

	private static final int KEYBOARD_ANIMATION_DELAY = 1000;
	private static final int XML_REFRESH_DELAY = 1000;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	private MobileElement preference;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='9. Switch']")
	private MobileElement switchs;

	@AndroidFindAll({ @AndroidBy(className = "android.widget.Switch") })
	private List<MobileElement> toggleButtons;

	public ToggleFuncPage(AppiumDriver driver) {
		super(driver);
	}

	public void navigateSwitch() {
		preference.click();
		switchs.click();

	}

	public void toogleSwitch() {

		MobileElement toggle = toggleButtons.get(0);

		// Performing gesture tap action
		int startX = toggle.getLocation().getX();
		int startY = toggle.getLocation().getY();

		new TouchAction(driver).tap(point(startX + 20, startY + 30)).perform();
	}

	public String verifyToggleButton() throws InterruptedException {
		MobileElement toggle = toggleButtons.get(0);
		return toggle.getText();
	}

}
