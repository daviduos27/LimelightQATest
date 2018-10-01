package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import model.SearchItem;

public class SearchResultsPage {
	
	private By lowPriceInput = By.id("low-price");
	private By highPriceInput = By.id("high-price");
	private By btnGo = By.xpath("//*[contains(@class,'a-button a-spacing')]/span");
	
	private WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void sortByOption(String option) {
		driver.findElement(By.xpath("//span[contains(text(),'" + option + "')]")).click();	
	}
	
	public void sortByPrice(String lowPrice, String highPrice) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(lowPriceInput));
		
		driver.findElement(lowPriceInput).sendKeys(lowPrice);
		driver.findElement(highPriceInput).sendKeys(highPrice);
		driver.findElement(btnGo).click();	
		
	}

	public List<SearchItem> getListOfResults() {
		List<WebElement> listOfResults= driver.findElements(By.tagName("h2"));
		List<WebElement> listOfPrices= driver.findElements(By.xpath("//*[contains(@class,'sx-price sx-price-large')]"));
		List<WebElement> listOfRatings= driver.findElements(By.xpath("//*[contains(@name,'B00')]/span/a/i/span"));
		List<SearchItem> searchItemList  = new ArrayList<>();
		 for(int i=0;i<5;i++) {
			 String name = listOfResults.get(i).getText();
			 String price = listOfPrices.get(i).getText();
			 String rating = listOfRatings.get(i).getAttribute("textContent");
			 
			 System.out.println("Search Result: " + (i+1) + System.lineSeparator() + "Name : " + name);
			 System.out.println("Price : " + price);
			 System.out.println("Rating : " + rating);
			 
			 searchItemList.add(new SearchItem(name, Float.parseFloat(price.substring(2, 7).replace(" ", ".")), Float.parseFloat(rating.substring(0, 2))));			 
		 }
		return searchItemList; 
	}

}
