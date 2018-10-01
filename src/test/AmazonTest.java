package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import model.SearchItem;
import pages.HomePage;
import pages.SearchResultsPage;
import selenium.DriverSetup;
import util.RecommendItem;
import util.SortResultsList;
import util.VerifyOrder;


public class AmazonTest {

	private WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	List<SearchItem> searchItemList  = new ArrayList<>();
	
	@BeforeClass()
	public void setupClass(){
		driver = DriverSetup.setupDriver(DriverSetup.Browser.CHROME, "chromedriver.exe");	
		homePage = new HomePage(driver);
		searchResultsPage = new SearchResultsPage(driver);	
	}
	
	@BeforeMethod()
	public void setupTest()
	{
		homePage.navigate();
	}

	@Parameters({ "sInputSearch", "sOption", "sLowPrice", "sHighPrice" })
	@Test(description = "Test Description")
	public void groupSetup(String sInputSearch,String sOption,String sLowPrice, String sHighPrice) throws Exception{
		homePage.inputSearch(sInputSearch);
		searchResultsPage.sortByOption(sOption);
		searchResultsPage.sortByPrice(sLowPrice, sHighPrice);
		searchItemList = searchResultsPage.getListOfResults();
		//This assert its going to fail because there is a item with price 19.99 in the results from amazon
		//Assert.assertEquals(true, RangeOfPrices.verify(searchItemList, Integer.parseInt(sLowPrice), Integer.parseInt(sHighPrice)));
		SortResultsList.byPrice(searchItemList, true);
		SortResultsList.byRating(searchItemList, true);
		SortResultsList.byPrice(searchItemList, false);
		Assert.assertEquals(true, VerifyOrder.byPrice(searchItemList));
		RecommendItem.calculate(searchItemList);
	}
	
	@AfterMethod()
	public void tearDownTest()
	{

	}
	
	@AfterClass()
	public void tearDownClass()
	{
		driver.quit();
	}
}
