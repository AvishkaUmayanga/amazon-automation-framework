package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageobjects.AccessoriesOnePage;
import pageobjects.CellPhonesAccessoriesPage;
import pageobjects.CheckoutPage;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.ShoppingCartPage;
import pageobjects.SigninPage;
import resouces.Base;
import utilities.ExtentReporter;


@Listeners(listeners.Listeners.class)
public class AmazonTest extends Base{
	public WebDriver driver = null;
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@BeforeMethod
	public void openAmazonPage() throws IOException {
		
		ExtentReporter extentReporter = new ExtentReporter();
		extentReport = ExtentReporter.getExtentReport();
	}
	
	@Test(priority=1)
	public void Login() throws IOException {
		
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.accountAndList().click();
		
		SigninPage signinPage = new SigninPage(driver);
		signinPage.emailField().sendKeys(prop.getProperty("email"));
		signinPage.continueButton().click();
		
		signinPage.passwordlField().sendKeys(prop.getProperty("password"));
		signinPage.signInButton().click();
		
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.helloText().isDisplayed());
	}
	
	@Test(dependsOnMethods = "Login")
	public void NavigateToPhonesAccessories() {
		
		 HomePage homePage = new HomePage(driver);
		 homePage.allTab().click();
		 homePage.electronicTab().click();
		 homePage.cellPhonesAccessoriesTab().click();
		 
		 CellPhonesAccessoriesPage phoneAcc = new CellPhonesAccessoriesPage(driver);
		 Assert.assertTrue(phoneAcc.CellPhonesAccessoriesText().isDisplayed());
	 }
	
	
	@Test(dependsOnMethods = "NavigateToPhonesAccessories")
	public void NavigateToAccessoriesOne() {
		CellPhonesAccessoriesPage phoneAcc = new CellPhonesAccessoriesPage(driver);
		phoneAcc.accessoriesOneBox().click();
		
		AccessoriesOnePage accOnePage = new AccessoriesOnePage(driver);
		Assert.assertTrue(accOnePage.addCartButton().isDisplayed()); 
	}
	
	@Test(dependsOnMethods = "NavigateToAccessoriesOne")
	public void ItemAddedToCart() {
		AccessoriesOnePage accOnePage = new AccessoriesOnePage(driver);
		accOnePage.addCartButton().click();
		Assert.assertTrue(accOnePage.addedToCartText().isDisplayed()); 
	}
	
	@Test(dependsOnMethods = "ItemAddedToCart")
	public void NavigateToShoppingCart(){
		AccessoriesOnePage accOnePage = new AccessoriesOnePage(driver);
		accOnePage.goToCartButton().click();
		
		ShoppingCartPage cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.shoppingCartText().isDisplayed()); 
	}
	
	@Test(dependsOnMethods = "NavigateToShoppingCart")
	public void navigateToCheckOut() {
		ShoppingCartPage cartPage = new ShoppingCartPage(driver);
		cartPage.checkOutButton().click();
		
		CheckoutPage checkOutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkOutPage.orderSummaryText().isDisplayed()); 
		
		driver.close();
		//extentReport.flush();
	}
	
	
	@AfterMethod
	public void closure() {
		//driver.close();
		extentReport.flush();
	}
}
