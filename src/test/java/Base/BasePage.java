package Base;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {
	private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;
    
    protected final AppiumDriver driver;
    
    protected BasePage(AppiumDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
    
    protected boolean sendKeysToElement(String input, WebElement element, boolean appendNewLine) throws InterruptedException {
    	final int MAX_ATTEMPTS = 3;
    	
    	for (int i =0; i<MAX_ATTEMPTS; i++ ) {
    		
    		element.clear();
    		
    		if(appendNewLine) {
    			element.sendKeys(input + "\n");
            } else {
                element.sendKeys(input);
            }
    		
    		Thread.sleep(XML_REFRESH_DELAY);
    		
    		if (element.getText().contains(input)==true) {
    			break;
    		}
    			
    	}
    	return element.getText().contains(input);
    	
    }

}
