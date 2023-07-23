package guru99;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupHandleTest {

	WebDriver driver;
	String url ="http://live.techpanda.org/";
	HomePage home;
	MobilePage mobile;
	PopupHandle popUpHandle;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		home = new HomePage(driver);
		mobile = new MobilePage(driver);
		popUpHandle = new PopupHandle(driver);

	}


	@Test
	public void popUpHandle() throws InterruptedException {
		//click mobile Menu
		home.clickMobileMenu();
		popUpHandle.clickSonyXperia();
		popUpHandle.clickIphone();
		popUpHandle.clickComparetBtn();
		Thread.sleep(2000);
		//close popup window
		Set<String>handles = driver.getWindowHandles();
		Iterator<String>it = handles.iterator();
		//print size of window handle
		System.out.println(handles.size());

		String parentWindow = it.next();
		System.out.println(parentWindow);

		String childWindow = it.next();
		System.out.println(childWindow);
		//switch to childwindow
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());

		popUpHandle.clickCloseWindow();
		Thread.sleep(1000);
		//switch to parent window
		driver.switchTo().window(parentWindow);

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}


}
