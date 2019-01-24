package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class BaseTest extends AbstractTestNGCucumberTests {
	public static AndroidDriver<MobileElement> driver;

	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		this.setUpAppium();
	}

	public void setUpAppium() throws MalformedURLException {
		final String environment = System.getProperty("env");
		final String appName = "ApiDemos-debug.apk";
		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

		URL url = new URL(URL_STRING);
		DesiredCapabilities capabilities = new DesiredCapabilities();

		File f = new File("src");
		File fs = new File(f, appName);

		if (environment == null || !environment.equals("ci")) {

			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");
		
			

		} else if (environment.equals("srini-local")) {
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

		}

		capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability("automationName", "uiautomator2");

		driver = new AndroidDriver<MobileElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void tearDownAppium() {
		driver.quit();
	}
}
