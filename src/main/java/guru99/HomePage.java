package guru99;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	
	WebDriver driver;
	By heading = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div/h2");
	By mobile = By.xpath("//*[@id=\"nav\"]/ol/li[1]/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String  getHeading() {
		String head = driver.findElement(heading).getText();
		return head;
	}
	
	public void clickMobileMenu() {
		driver.findElement(mobile).click();
	}

}
