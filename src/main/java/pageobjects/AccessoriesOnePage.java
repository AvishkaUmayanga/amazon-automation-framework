package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesOnePage {
	
	WebDriver driver;
	
	public AccessoriesOnePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-to-cart-button")
	WebElement addCartButton;
	
	@FindBy(xpath="//span[normalize-space()='Added to Cart']")
	WebElement addedToCartText;
	
	@FindBy(id="sw-gtc")
	WebElement goToCartButton;
	
	public WebElement addCartButton() {
		return addCartButton;
	}
	
	public WebElement addedToCartText() {
		return addedToCartText;
	}
	
	public WebElement goToCartButton() {
		return goToCartButton;
	}
}
