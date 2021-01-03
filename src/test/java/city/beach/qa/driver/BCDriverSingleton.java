package city.beach.qa.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Singleton Class to share a driver across all classes.
 * Partially based on code examples in the book 
 * Selenium Framework Design in Data-Driven Testing
 * By Carl Cocchiaro.
 * 
 * @author Jacqueline Button
 *
 */
public class BCDriverSingleton {
	private static BCDriverSingleton driver_instance = null;
	
	private ThreadLocal<WebDriver> webDriver = 
		new ThreadLocal<WebDriver>();
	
	private ThreadLocal<String> sessionId =
			new ThreadLocal<String>();
	
	private ThreadLocal<String> sessionBrowser =
			new ThreadLocal<String>();
	
	private ThreadLocal<String> sessionPlatform =
			new ThreadLocal<String>();
	
	private ThreadLocal<String> sessionVersion =
			new ThreadLocal<String>();
	
	private String getEnv = null;
	
	/**
	 * Private constructor to force the class to be a singleton.
	 */
	private BCDriverSingleton() {
	}
	
	public static BCDriverSingleton getInstance () {
		if ( driver_instance == null ) {
			driver_instance = new BCDriverSingleton();
		}
		
		return driver_instance;
	}
	
	/**
	 * Sets a driver based on parameters passed to it.
	 * @param browser A String with the browser name. 
	 * @param platform
	 * @param environment
	 * @param optPreferences
	 */
	public final void setDriver(String browser,
								String platform,
								String environment,
								Map<String, Object> optPreferences) {
		//TODO Handle platform param.
		//TODO Handle environment param.
		//TODO Handle optPrferences param.
		
		DesiredCapabilities caps = null;
		
		switch (browser) {
		case "chrome":
			caps = DesiredCapabilities.chrome();
			ChromeOptions chromeSettings = new ChromeOptions();
			Map<String, Object> chromePrefs = 
					new HashMap<String, Object>();
			
			// Set ChromeDriver path
			String os = System.getProperty("os.name");
			if (os.equals("Windows 10")) {
				System.setProperty("webdriver.chrome.driver", "./tools/drivers/Win10/chromedriver.exe");
			}
			
			webDriver.set(new ChromeDriver(chromeSettings));
			
			break;
		}
	}
	
	/**
	 * Returns the current WebDriver.
	 * @return WebDriver.
	 */
	public WebDriver getDriver() {
		return webDriver.get();
	}
	
	public void driverWait(long seconds) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
		} catch (InterruptedException e) {
			//TODO handle DriverSingleton's wait failing.
		}
	}
	
	/**
	 * Returns the current driver.
	 * @return The current driver.
	 */
	public WebDriver getCurrentDriver() {
		return getInstance().getDriver();
	}
	
	/**
	 * Refreshes the current driver.
	 */
	public void driverRefresh() {
		 getCurrentDriver().navigate().refresh();
	}
	
	/**
	 * Gets the current session Id
	 * @return
	 */
	public String getSessionId() {
		return sessionId.get();
	}
	
	/**
	 * Gets the current Session Browser.
	 * @return The Session Browser.
	 */
	public String getSessionBrowser() {
		return sessionBrowser.get();
	}
	
	/**
	 * Gets the current SessionVersion()
	 * @return
	 */
	public String getSessionVersion() {
		return sessionVersion.get();
	}
	
	/**
	 * Returns the current Session Platform.
	 * @return
	 */
	public String getSessionPlatform() {
		return sessionPlatform.get();
	}
	
	/**
	 * Closes the driver.
	 */
	public void closeDriver() {
		try {
			getCurrentDriver().quit();
		} catch (Exception e ) {
			//TODO handle closeDriver() failing to quit.
		}
	}
}
