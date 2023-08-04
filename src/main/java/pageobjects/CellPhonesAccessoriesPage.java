package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CellPhonesAccessoriesPage {
	
	WebDriver driver;
	
	public CellPhonesAccessoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@data-csa-c-type='element']//li//span//span[contains(text(),'Cell Phones & Accessories')]")
	WebElement CellPhonesAccessoriesText;
	
	@FindBy(xpath = "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//div[@class='a-section aok-relative s-image-square-aspect']")
    WebElement accessoriesOneBox;
	
	
	public WebElement CellPhonesAccessoriesText() {
		return CellPhonesAccessoriesText;
	}
	
	public WebElement accessoriesOneBox() {
		return accessoriesOneBox;
	}
}
