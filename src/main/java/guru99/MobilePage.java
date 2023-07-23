package guru99;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {
	WebDriver driver;
	By sort = By.xpath("//select[@title='Sort By']");
	By sonyXperia = By.xpath("//*[@id=\"product-collection-image-1\"]");
	By actualDetailPrice = By.xpath("//span[@class='price']");
	By xperiaPrice = By.id("product-price-1");

	public MobilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectSortByText(String optionName) {
		WebElement element = driver.findElement(sort);
		Select sortSelect = new Select(element);
		sortSelect.selectByVisibleText(optionName);
		
	}
	
	public void clickSonyXperia() {
		driver.findElement(sonyXperia).click();
		
	}
	
	
	public String getDetailPrice() {
		
		String detailPrice = driver.findElement(actualDetailPrice).getText();
		return detailPrice;
	}
	
	public String getlistPrice() {
		String expectedPrice = driver.findElement(xperiaPrice).getText();
		return expectedPrice;
	}
			
}
