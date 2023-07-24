package guru99;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest {


	WebDriver driver;
	String url ="http://live.techpanda.org/";
	CreateAccount account;
	String name = "Swapnil";
	String middlename = "Satish";
	String lastname = "Raykar";
	String pwd = "test@123";
	String email = "sbrrwapnalibhujbal1296@gmail.com";
	String emailAddress = "ssswapnalibhujbal1296@gmail.com";
	String emailMsg = "Hi";


	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		account = new CreateAccount(driver);
	}

	@Test
	public void createAccount() {
		account.clickAccount();
		account.clickMyAccount();
		account.clickAnAccount();
		account.enterFirstname(name);
		account.enterMiddleName(middlename);
		account.enterLastName(lastname);
		account.enterEmail(email);
		account.enterPassword(pwd);
		account.enterConfirmPassword(pwd);
		account.clickRegisterBtn();
		//account.clickSignUp();

		//validate register msg
		String expected = "Thank you for registering with Main Website Store.";
		String actual = account.getRegistrationMsg();
		Assert.assertEquals(expected, actual);

		//click TV menu
		account.clickTVBtn();
		//click wishlist
		account.clickWishList();
		//click share wishList
		account.clickShareWishList();
		//enter email address
		account.enterEmailAddress(emailAddress);
		account.enterEmailMessage(emailMsg);
		//click share wishlist
		account.clickShareWishList1();
		//validate successfully msg
		String expectedMsg = "Your Wishlist has been shared.";
		String actualMsg = account.getSuccessfullyMsg();
		Assert.assertEquals(expectedMsg, actualMsg);

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		//driver.close();
	}

}
