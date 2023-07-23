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

public class MobilePageTest {
	
	WebDriver driver;
	String url ="http://live.techpanda.org/";
	HomePage home;
	MobilePage mobile;
	
	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		home = new HomePage(driver);
		mobile = new MobilePage(driver);
	}
	
	
	
	
	@Test
	public void verifyProdutCost() throws InterruptedException{
		
		home.clickMobileMenu();
		System.out.println("listPrice:"+mobile.getlistPrice());
		
		mobile.clickSonyXperia();
		Thread.sleep(2000);
		System.out.println("detailPrice:"+mobile.getDetailPrice());
		
		//take in strings & assert
		String listPrice = mobile.getlistPrice();
		String DetailsPrice = mobile.getDetailPrice();
		Assert.assertEquals(listPrice, DetailsPrice);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
