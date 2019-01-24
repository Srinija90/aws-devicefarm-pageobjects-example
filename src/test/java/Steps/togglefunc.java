package Steps;

import org.testng.Assert;

import Base.BaseTest;
import Pages.AddWifiPortPage;
import Pages.ToggleFuncPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class togglefunc extends BaseTest {

	private static final String TOGGLE = "ON";


	@And("^toggles switch$")
	public void addNewWifi() throws InterruptedException {
		ToggleFuncPage toggleFuncPage = new ToggleFuncPage(driver);
		toggleFuncPage.toogleSwitch();
	}

	@Then("^switch preference should turn off$")
	public void verifyAddedNewWifi() throws InterruptedException {
		ToggleFuncPage toggleFuncPage = new ToggleFuncPage(driver);
		
		Assert.assertEquals(toggleFuncPage.verifyToggleButton(), TOGGLE);
	}

}
