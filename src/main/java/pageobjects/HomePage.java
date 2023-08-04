package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Hello, Avishka']")
	WebElement helloText;
	
	@FindBy(id="nav-hamburger-menu")
	WebElement allTab;
	
	@FindBy(linkText="Electronics")
	WebElement electronicTab;
	
	@FindBy(linkText="Cell Phones & Accessories")
	WebElement cellPhonesAccessoriesTab;
	
	public WebElement helloText() {
		return helloText;
	}
	
	public WebElement allTab() {
		return allTab;
	}
	
	public WebElement electronicTab() {
		return electronicTab;
	}
	
	public WebElement cellPhonesAccessoriesTab() {
		return cellPhonesAccessoriesTab;
	}
}
