package city.beach.qa.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import city.beach.qa.driver.BCDriverSingleton;

/**
 * @author Jacqueline Button
 * Class for handling element synchronization.
 * Partially based on examples in the book 
 * "Selenium Framework Design in Data-driven testing." by Carl Cocchiaro. 
 */
public class BCSyncTools {
	
	/**
	 * Waits for an element to exist. 
	 * @param element The WebElement to look for.
	 * @param waitTime The amount of time to wait for in seconds.
	 * @throws Exception The exception to be thrown if it still exists.
	 */
	public static void waitForElement(WebElement element,
								   int waitTime)
								   throws Exception {
	WebDriver driver = BCDriverSingleton.getInstance().getDriver();
	WebDriverWait doesElementExist = new WebDriverWait(driver,
													   waitTime);
	doesElementExist.until(ExpectedConditions.refreshed(
				 ExpectedConditions.visibilityOf(element)));
	
	}
	
	/**
	 * Overloaded waitForElement method to wait up to a designated period for
	 * a dynamic locator before throwing exception.
	 *
	 * @param by The locator to look for.
	 * @param waitTime The amount of time to wait for in seconds.
	 * @throws Exception The exception to be thrown if it still exists.
	 */
	public static void waitForElement(By by,
	                           int waitTime)
	                           throws Exception {
		
	    WebDriver driver = BCDriverSingleton.getInstance().getDriver();
	    
	    // wait for the dynamic element to appear
	    WebDriverWait doesElementExist = new WebDriverWait(driver,
	                                             waitTime);
	    doesElementExist.until(ExpectedConditions.refreshed(
	                 ExpectedConditions.visibilityOfElementLocated(by)));
	}

	/**
	 * A method to wait up to a designated period before
	 * throwing an exception if element still exists
	 *
	 * @param by The locator to look for.
	 * @param waitTime The amount of time to wait for in seconds.
	 * @throws Exception The exception to be thrown if it still exists.
	 */
	public static void waitForGone(By by,
	                               int waitTime)
	                               throws Exception {

	    WebDriver driver = BCDriverSingleton.getInstance().getDriver();

	    // wait for the dynamic element to disappear
	    WebDriverWait exists = new WebDriverWait(driver,
	                                             waitTime);
	    
	    exists.until(ExpectedConditions.refreshed(
	                 ExpectedConditions.invisibilityOfElementLocated(by)));
	}
	
	/**
	 * A method to wait up to a designated period before
	 * throwing exception if URL is not found
	 *
	 * @param by The locator to look for.
	 * @param waitTime The amount of time to wait for in seconds.
	 * @throws Exception The exception to be thrown if it still exists.
	 */
	public static void waitForURL(String url,
	                              int waitTime)
	                              throws Exception {

	    WebDriver driver = BCDriverSingleton.getInstance().getDriver();
	    WebDriverWait exists = new WebDriverWait(driver,
	                                             waitTime);

	    exists.until(ExpectedConditions.refreshed(
	    ExpectedConditions.urlContains(url)));
	}

	/**
	 * A method to wait up to a designated period before
	 * throwing exception if Title is not found
	 *
	 * @param by The locator to look for.
	 * @param waitTime The amount of time to wait for in seconds.
	 * @throws Exception The exception to be thrown if it still exists.
	 */
	public void waitFor(String title,
	                    int waitTime)
	                    throws Exception {

	     WebDriver driver = BCDriverSingleton.getInstance().getCurrentDriver();
	     WebDriverWait exists = new WebDriverWait(driver, waitTime);

	     exists.until(ExpectedConditions.refreshed(
	                  ExpectedConditions.titleContains(title)));
	}
}
