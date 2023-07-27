package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyPDFFile {
	WebDriver driver;
	By myOrder = By.xpath("//a[text()='My Orders']");
	By viewOrder = By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[1]");
	By verifyOrderMsg = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/h1");
	By printOrderLink = By.xpath("//a[text90='Print Order']");

	public VerifyPDFFile(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyOrder() {
		driver.findElement(myOrder).click();
	}
	public void clickViewOrder() {
		driver.findElement(viewOrder).click();
	}
	public String verifyOrderMsg() {
		String element = driver.findElement(verifyOrderMsg).getText();
		return element;
	}
	public void clickPrintOrderLink() {
		driver.findElement(printOrderLink).click();
	}
}
