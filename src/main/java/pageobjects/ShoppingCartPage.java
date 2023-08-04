package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Shopping Cart']")
	WebElement shoppingCartText;
	
	@FindBy(id="sc-buy-box-ptc-button")
	WebElement checkOutButton;
	
	public WebElement shoppingCartText() {
		return shoppingCartText;
	}
	
	public WebElement checkOutButton() {
		return checkOutButton;
	}
}
