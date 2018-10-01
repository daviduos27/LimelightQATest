package selenium;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {

	static String pathToDriver = Paths.get("").toAbsolutePath().toString() +File.separator + "driver" + File.separator;
    
	public enum Browser {
        CHROME,
        IE,
        FIREFOX
    }
    
	public static WebDriver setupDriver(Browser browser, String driverFileName) {
		WebDriver driver = null;
		if(browser == Browser.CHROME) {
			System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
			driver = new ChromeDriver();
		}
		
//		else if(browser == Browser.FIREFOX) {
//			System.setProperty("webdriver.gecko.driver", pathToDriver + driverFileName);
//			driver = new FirefoxDriver();
//		}
		
		else if(browser == Browser.IE) {
			System.setProperty("webdriver.firefox.driver", pathToDriver + driverFileName);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
}
