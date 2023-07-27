package guru99;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyPDFFileTest {


	WebDriver driver;
	String url ="http://live.techpanda.org/";
	VerifyPDFFile pdfFile;
	CreateAccount account;
	PurchaseProduct product;
	String email = "sbrrwapnalibhujbal1296@gmail.com";
	String pwd = "test@123";
	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		account = new CreateAccount(driver);
		product = new PurchaseProduct(driver);
		pdfFile = new VerifyPDFFile(driver);

	}
	@Test
	public void verifyPDFfile() throws InterruptedException {
		account.clickAccount();
		account.clickMyAccount();
		product.enteremail(email);
		product.enterPassword(pwd);
		product.clickLoginBtn();
		Thread.sleep(2000);
		pdfFile.clickMyOrder();
		pdfFile.clickViewOrder();
		Thread.sleep(1000);
		String expectedMsg = "ORDER #100019743 - PENDING";
		String actualMsg = pdfFile.verifyOrderMsg();
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		pdfFile.clickPrintOrderLink();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		//driver.close();
	}

}
