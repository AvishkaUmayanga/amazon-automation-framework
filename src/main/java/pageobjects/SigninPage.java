package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
	WebDriver driver;
	
	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	WebElement emailField;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	WebElement passwordlField;
	
	@FindBy(id="signInSubmit")
	WebElement signInButton;
	
	
	public WebElement emailField() {
		return emailField;
	}
	
	public WebElement continueButton() {
		return continueButton;
	}
	
	public WebElement passwordlField() {
		return passwordlField;
	}
	
	public WebElement signInButton() {
		return signInButton;
	}
}
