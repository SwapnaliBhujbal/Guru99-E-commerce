package guru99;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseProductTest {

	WebDriver driver;
	String url ="http://live.techpanda.org/";
	CreateAccount account;
	String email = "sbrrwapnalibhujbal1296@gmail.com";
	String pwd = "test@123";
	PurchaseProduct product;
	String country1 = "United States";
	String state1 = "New York";
	String zipcode1 = "542896";
	String city = "New York";
	String zcode = "542896";
	String country = "United States";
	String num = "12345678";
	String states = "New York";



	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		account = new CreateAccount(driver);
		product = new PurchaseProduct(driver);

	}

	@Test
	public void purchaseProduct() throws InterruptedException, IOException {
		account.clickAccount();
		account.clickMyAccount();
		product.enteremail(email);
		product.enterPassword(pwd);
		product.clickLoginBtn();
		Thread.sleep(2000);
		product.clickWishListLink();
		product.addToCartBtn();
		//product.clickCartBtn();
		product.enterCOUNTRY(country1);
		product.enterSTATES(state1);
		product.enterZIPCODE(zipcode1);
		product.clickEstimateBtn();
		product.clickupdateBtn();
		product.clickProcedBtn();
		Thread.sleep(1000);
		product.clickRadioBtn2();
		
		
		Thread.sleep(2000);
		product. clickContinueBtn();
		product.clickContinueBtn1();
		product.clickRadioBtn();
		product.clickContinueBtn2();
		product. clickPlaceorderBtn();
		Thread.sleep(2000);
		//takes screenshot of order Number

		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("E:\\GitRepository\\Guru99-E-commerce\\src\\main\\resources\\OrderNumber.png"));
		/*
		product.enteraddress(adr);
		product.enterCity(city);
		product.enterZcode(zcode);
		product.enterCountry(country);
		product.enterTelephoneNum(num);
		product.enterStates(states);*/
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
