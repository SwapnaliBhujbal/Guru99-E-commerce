package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccount {

	WebDriver driver;
	By Account = By.xpath("//a[@data-target-element='#header-account']");
	By myAccount = By.xpath("//a[@title='My Account']");
	By createAnAccount = By.xpath("//a[@title='Create an Account']");
	By firstName = By.id("firstname");
	By middleName = By.id("middlename");
	By lastName = By.id("lastname");
	By password = By.id("password");
	By confirmPassword = By.id("confirmation");
	By Email = By.id("email_address");
	By signup = By.id("is_subscribed");
	By registerBtn = By.xpath("//button[@title='Register']");
	By registrationMsg = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span");
	By Tv = By.xpath("//a[text()='TV']");
	By wishList = By.xpath("//a[text()='Add to Wishlist']");
	By shareWishList = By.name("save_and_share");
	By emailaddress = By.id("email_address");
	By enterEmailMsg = By.id("message");
	By shareWishlist1 = By.xpath("//button[@title='Share Wishlist']");
	By successMsg = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span");



	public CreateAccount(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAccount() {
		driver.findElement(Account).click();
	}
	public void clickMyAccount() {
		driver.findElement(myAccount).click();
	}
	public void clickAnAccount() {
		driver.findElement(createAnAccount).click();
	}
	public void enterFirstname(String name) {
		driver.findElement(firstName).sendKeys(name);

	}
	public void enterMiddleName(String middlename) {
		driver.findElement(middleName).sendKeys(middlename);

	}
	public void enterLastName(String lastname) {
		driver.findElement(lastName).sendKeys(lastname);
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void enterConfirmPassword(String Cpwd) {
		driver.findElement(confirmPassword).sendKeys(Cpwd);
	}
	public void enterEmail(String email) {
		driver.findElement(Email).sendKeys(email);
	}
	public void clickSignUp() {
		driver.findElement(signup).click();
	}
	public void clickRegisterBtn() {
		driver.findElement(registerBtn).click();
	}

	public String getRegistrationMsg() {
		String actual = driver.findElement(registrationMsg).getText();
		return actual;
	}
	public void clickTVBtn() {
		driver.findElement(Tv).click();
	}
	public void clickWishList() {
		driver.findElement(wishList).click();
	}
	public void clickShareWishList() {
		driver.findElement(shareWishList).click();
	}
	public void enterEmailAddress(String emailAddress) {
		driver.findElement(emailaddress).sendKeys(emailAddress);
	}
	public void enterEmailMessage(String emailMsg) {
		driver.findElement(enterEmailMsg).sendKeys(emailMsg);
	}
	public void clickShareWishList1() {
		driver.findElement(shareWishlist1).click();
	}
	public String getSuccessfullyMsg() {
		String actualMsg = driver.findElement(successMsg).getText();
		return actualMsg;
	}


}
