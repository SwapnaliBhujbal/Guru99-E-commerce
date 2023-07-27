package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PurchaseProduct {

	WebDriver driver;

	By eemail = By.id("email");
	By ppwd = By.id("pass");
	By login = By.id("send2");
	By wishlistLink = By.xpath("//a[text()='My Wishlist']");
	By addtoCartBtn = By.xpath("//button[@title='Add to Cart']");
	//By cart = By.xpath("//a[@data-target-element='#header-cart']");
	By COUNTRY = By.id("country");
	By STATE = By.id("region_id");
	By ZIPCODE = By.id("postcode");
	By estimate = By.xpath("//button[@title='Estimate']");
	By updateBtn = By.xpath("//button[@title='Update Total']");
	By continueBtn = By.xpath("//button[@title='Continue']");
	By continueBtn1 = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
	By radioBtn = By.id("p_method_checkmo");
	By continue2 = By.xpath("//*[@id=\"payment-buttons-container\"]/button");
	By placeorderBtn = By.xpath("//button[@title='Place Order']");
	By procedBtn = By.xpath("//button[@title='Proceed to Checkout']");
	By conRadioBtn = By.xpath("//input[@title='Ship to this address']");
	/*
	By address = By.id("billing:street1");
	By City = By.id("billing:city");
	By zipCode = By.xpath("//input[@title='Zip']");
	By Country = By.id("billing:country_id");
	By telephone = By.id("billing:telephone");
	By States = By.id("billing:region_id");*/


	public PurchaseProduct(WebDriver driver) {
		this.driver = driver;
	}

	public void enteremail(String email) {
		driver.findElement(eemail).sendKeys(email);

	}
	public void enterPassword(String pwd) {
		driver.findElement(ppwd).sendKeys(pwd);
	}
	public void clickLoginBtn() {
		driver.findElement(login).click();
	}
	public void clickWishListLink() {
		driver.findElement(wishlistLink).click();
	}
	public void addToCartBtn() {
		driver.findElement(addtoCartBtn).click();
	}
	public void clickCartBtn() {
		driver.findElement(addtoCartBtn).click();
	}
	public void enterCOUNTRY(String country1) {
		WebElement element = driver.findElement(COUNTRY);
		Select selectCountry = new Select(element);
		selectCountry.selectByVisibleText(country1);
	}
	public void enterSTATES(String state1) {
		WebElement element = driver.findElement(STATE);
		Select selectState1 = new Select(element);
		selectState1.selectByVisibleText(state1);
	}
	public void enterZIPCODE(String zipcode1) {
		driver.findElement(ZIPCODE).sendKeys(zipcode1);
	}
	public void clickEstimateBtn() {
		driver.findElement(estimate).click();
	}
	public void clickupdateBtn() {
		driver.findElement(updateBtn).click();
	}
	public void clickProcedBtn() {
		driver.findElement(procedBtn).click();
	}
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
	public void clickContinueBtn1() {
		driver.findElement(continueBtn1).click();
	}
	public void clickRadioBtn() {
		driver.findElement(radioBtn).click();
	}
	public void clickContinueBtn2() {
		driver.findElement(continue2).click();
	}
	public void clickPlaceorderBtn() {
		driver.findElement(placeorderBtn).click();
	}
	public void clickRadioBtn2() {
		driver.findElement(conRadioBtn).click();
	}

	/*
	public void enteraddress(String adr) {
		driver.findElement(address).sendKeys(adr);
	}
	public void enterCity(String city) {
		driver.findElement(City).sendKeys(city);
	}
	public void enterStates(String states) {
		WebElement element = driver.findElement(States);
		Select select = new Select(element);
		select.selectByVisibleText(states);
	}
	public void enterZcode(String zcode) {
		driver.findElement(zipCode).sendKeys(zcode);
	}
	public void enterCountry(String country) {
		WebElement element = driver.findElement(Country);
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(country);
	}
	public void enterTelephoneNum(String num) {
		driver.findElement(telephone).sendKeys(num);
	}*/


}
