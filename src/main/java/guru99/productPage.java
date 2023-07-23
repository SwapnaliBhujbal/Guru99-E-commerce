package guru99;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPage {
	
	WebDriver driver;
	By addToCartBtn = By.xpath("//button[@class='button btn-cart']");
	By addQuantity = By.xpath("//input[@title='Qty']");
	By updateBtn = By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button");
	By actualMsg = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/p");
	By emptyCartBtn = By.id("empty_cart_button");
	By emptyCartMsg = By.xpath("//div[@class='page-title']/h1");
	
	public productPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddToCartBtn() {
		driver.findElement(addToCartBtn).click();
	}
	
	public void quantityAdd(String quantity) {
		driver.findElement(addQuantity).clear();
		driver.findElement(addQuantity).sendKeys(quantity);
		
	}
	public void clickUpdateBtn() {
		driver.findElement(updateBtn).click();
	}
	public String getActualMsg() {
		String msg = driver.findElement(actualMsg).getText();
		return msg;
	}
	public void clickEmptyCart() {
		driver.findElement(emptyCartBtn).click();
	}
	public String getEmptyCartMsg() {
		String msg = driver.findElement(emptyCartMsg).getText();
		return msg;
		
	}
	

}
