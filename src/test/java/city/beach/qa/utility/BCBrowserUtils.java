/**
 * 
 */
package city.beach.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import city.beach.qa.driver.BCDriverSingleton;

/** 
 * @author Carl Cocchiaro & Jacqueline Button.
 * Class for handling element synchronization.
 * Partially based on examples in the book 
 * "Selenium Framework Design in Data-driven testing." by Carl Cocchiaro. 
 */
public class BCBrowserUtils {
	/**
     * A method to poll the page title
     *
     * @param title The expected Title
     * @param waitTime The wait time in seconds.
     * @throws Exception The exception that gets thrown if it isn't found.
     */
    public static void waitForTitle(String title,
                               int waitTime)
                               throws Exception {

        WebDriver driver = BCDriverSingleton.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, waitTime);

        exists.until(ExpectedConditions.refreshed(
                     ExpectedConditions.titleContains(title)));
    }

    /**
     * A method to poll the page URL
     *
     * @param url The Expected URL
     * @param waitTime The wait time in seconds.
     * @throws Exception The exception that gets thrown if it isn't found.
     */
    public static void waitForURL(String url,
                                  int timer)
                                  throws Exception {

        WebDriver driver = BCDriverSingleton.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, timer);

        exists.until(ExpectedConditions.refreshed(
                     ExpectedConditions.urlContains(url)));
    }

    /**
     * A method to poll for locator to be clickable.
     *
     * @param by The locator to check.
     * @param waitTime The wait time in seconds.
     * @throws Exception The Exception that gets thrown if it isn't clickable.
     */
    public static void waitForClickable(By by,
                                        int timer)
                                        throws Exception {

        WebDriver driver = BCDriverSingleton.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, timer);

        exists.until(ExpectedConditions.refreshed(
                     ExpectedConditions.elementToBeClickable(by)));
    }

    /**
     * A method to click using JavaScript API click
     *
     * @param by The locator to click.
     * @throws Exception The Exception that gets thrown if it isn't clickable.
     */
    public static void clickViaJS(By by) throws Exception {
        WebDriver driver = BCDriverSingleton.getInstance().getDriver();
        WebElement element = driver.findElement(by);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }


    /*
     * A method to verify that a page has completely rendered
     *
     * @param driver the Web Driver to use.
     * @return boolean True if Page is Ready, False if not.
     */
    public static boolean isPageReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return (Boolean)js.executeScript("return document.readyState")
                                         .equals("complete");

    }
}
