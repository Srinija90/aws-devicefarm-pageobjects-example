package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddWifiPortPage extends BasePage {
	
	private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	private MobileElement preference;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	private MobileElement preferenceDependencies;
    
    @AndroidFindBy(className = "android.widget.CheckBox")
	private MobileElement checkbox;
    
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	private MobileElement wifiSettings;
    
    @AndroidFindBy(className = "android.widget.EditText")
	private MobileElement textbox;
    
    @AndroidFindBy(id = "android:id/button1")
	private MobileElement okButton;
	

	public AddWifiPortPage(AppiumDriver driver) {
		super(driver);
	}
	
	public void navigateAddWifiScreen() {
		preference.click();
		preferenceDependencies.click();
	}
	
	public boolean addWifi(String wifi) throws InterruptedException {
		checkbox.click();
		wifiSettings.click();
		boolean wifiname = sendKeysToElement(wifi, textbox, false);
		okButton.click();
		return wifiname;
	}
	
	public String verifyAddedWifi() {
		wifiSettings.click();
		return textbox.getText();
	}

}
