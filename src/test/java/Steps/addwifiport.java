package Steps;



import org.testng.Assert;

import Base.BaseTest;
import Pages.AddWifiPortPage;
import Pages.ToggleFuncPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addwifiport extends BaseTest { 
	
	private static final String WIFINAME = "srinija";
	
	
	
	@Given("^user logged into the application$")
	public void clickonSignUp() {
		// do nothing
	}
	
	@When("^user navigate to ([^\"]*) screen$")
	public void navigateToScreen(String field) {
		AddWifiPortPage addWifiPage = new AddWifiPortPage(driver);
		ToggleFuncPage toggleFuncPage = new ToggleFuncPage(driver);
		
		if (field.equals("addwifi")) {
			addWifiPage.navigateAddWifiScreen();
		} else if (field.equals("switch")) {
			toggleFuncPage.navigateSwitch();
		}
		
	}
	
	@And("^add new wifi port$")
	public void addNewWifi() throws InterruptedException {
		AddWifiPortPage addWifiPage = new AddWifiPortPage(driver);
		addWifiPage.addWifi(WIFINAME);
		
	}
	
	@Then("^newly added wifi port should be displayed$")
	public void verifyAddedNewWifi() {
		AddWifiPortPage addWifiPage = new AddWifiPortPage(driver);
		Assert.assertEquals(addWifiPage.verifyAddedWifi(), WIFINAME);
		
	}
}
