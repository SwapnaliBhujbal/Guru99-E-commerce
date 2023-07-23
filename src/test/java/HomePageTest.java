import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
	
	WebDriver driver;
	String url ="http://live.techpanda.org/index.php/";
	HomePage home;
	String sortOption;
	String screenshotDirPath ="E:\\GitRepository\\Guru99-E-commerce\\test-output\\Screenshot\\";
	
	
	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		home = new HomePage(driver);
		
		
		
	}
	
	@Test
	public void testTitle() throws InterruptedException, IOException {
		
		//validate title of the page
		String expectedTitle = "Home page";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//validate heading of the page
		String expectedHeading = "THIS IS DEMO SITE FOR   ";
		String actualHeading = home.getHeading();
		System.out.println(actualHeading);
		Assert.assertEquals(actualHeading, expectedHeading);
		
		//click mobileMenu
		Thread.sleep(2000);
		home.clickMobileMenu();
		
		//verify title of the page 
		String expectedTitle1 = "Mobile";
		String actualTitle1 = driver.getTitle();
		if(actualTitle1.equals(expectedTitle1)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		//test case for sorting
		sortOption = "Name";
		home.selectSortByText(sortOption);
		
		//takes scrrenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String png = ("C:\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + scc + ".png");
		FileUtils.copyFile(scrFile, new File(screenshotDirPath + "sort.png"));
		
		//list of mobilephone
		List<WebElement> mobileList = driver.findElements(By.xpath("//li/div/h2")); 
		System.out.println(mobileList.size());
		
		ArrayList<String> mobileNameList = new ArrayList<String>();
		for(WebElement e:mobileList) {
			System.out.println(e.getText());
			mobileNameList.add(e.getText());	
		}
		
		System.out.println("print mobileNameList");
		for(String name:mobileNameList) {
			System.out.println(name);
		}
		
		//created sorted list
		ArrayList<String> sortedList = new ArrayList<String>();
		for(String name: mobileNameList) {
			sortedList.add(name);
		}
		
		Collections.sort(sortedList);
		System.out.println("print sortedList");
		for(String name:sortedList) {
			System.out.println(name);
		}
		
		Assert.assertEquals(mobileNameList, sortedList);
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
