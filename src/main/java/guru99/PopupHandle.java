package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupHandle {
	
	WebDriver driver;
	By addToCompareSonyXperia = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a");
	By addToCompareIphone = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a");
	By compareBtn = By.xpath("//button[@title='Compare']");
	By closeSonyWindow = By.xpath("//button[@class='button']");
	
	public PopupHandle(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSonyXperia() {
		driver.findElement(addToCompareSonyXperia).click();
	}
	
	public void clickIphone() {
		driver.findElement(addToCompareIphone).click();
	}
	public void clickComparetBtn() {
		driver.findElement(compareBtn).click();
	}
	
	public void clickCloseWindow() {
		driver.findElement(closeSonyWindow).click();
	}

}
