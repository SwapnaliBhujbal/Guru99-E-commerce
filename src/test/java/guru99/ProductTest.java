package guru99;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import guru99.HomePage;
import guru99.MobilePage;
import guru99.productPage;

public class ProductTest {

	WebDriver driver;
	String url ="http://live.techpanda.org/index.php/";
	HomePage home;
	MobilePage mobile;
	productPage page;
	productPage productQuantity;
	
	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		home = new HomePage(driver);
		mobile = new MobilePage(driver);
		page = new productPage(driver);
		productQuantity = new productPage(driver);
	}

	@Test
	public void addToCart() throws InterruptedException {
		//click on mobile menu
		home.clickMobileMenu();
		//click sonyXperia
		mobile.clickSonyXperia();
		//click add to cart btn
		page.clickAddToCartBtn();
		//add quantity
		String quantity = "600";
		productQuantity.quantityAdd(quantity);
		//click update btn
		Thread.sleep(2000);
		productQuantity.clickUpdateBtn();
		//validate error msg
		String expectedMsg = "* The maximum quantity allowed for purchase is 500.";
		String actualMsg = productQuantity.getActualMsg();
		System.out.println("Error Massage is :" + actualMsg);
		Assert.assertEquals(actualMsg,expectedMsg);
		//click empty cart btn
		Thread.sleep(1000);
		productQuantity.clickEmptyCart(); 
		//verify message
		String expectedErrorMsg = "SHOPPING CART IS EMPTY";
		String actualErrorMsg = productQuantity.getEmptyCartMsg();
		System.out.println(actualErrorMsg);
		Assert.assertEquals(expectedErrorMsg,actualErrorMsg);

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
