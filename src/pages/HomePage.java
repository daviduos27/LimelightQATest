package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	static final String BASE_URL = "https://www.amazon.com";
	
	private By searchTextBox = By.id("twotabsearchtextbox");
	private By linkAmazon = By.id("nav-your-amazon");
	private By btnSubmit = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate() {
		driver.get(BASE_URL);
		driver.findElement(linkAmazon).isDisplayed();
	}
	
	public void inputSearch(String searchParameter) {
		driver.findElement(searchTextBox).clear();
		driver.findElement(searchTextBox).sendKeys(searchParameter);
		driver.findElement(btnSubmit).click();
	}

}
