package city.beach.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import city.beach.qa.driver.BCDriverSingleton;
import city.beach.qa.utility.BCBrowserUtils;
import city.beach.qa.utility.BCGlobalVariables;
import city.beach.qa.utility.BCSyncTools;

/**
 * This is an abstract class that will help
 * with implementing page objects for the beach.city test cases.
 * @author Jacqueline Button.
 *
 */
public abstract class GenericBrowserPO <M extends WebElement>{
	public int elementWait = BCGlobalVariables.TIMEOUT_ELEMENT;
	public String pageTitle = "";
	WebDriver driver = null;
	private String expPageTitle = "";
	private String actualPageTitle = "";
	private String url = null;
	
	/**
	 * Generic Constructor.
	 * @throws Exception
	 */
	public GenericBrowserPO() throws Exception {
		this.driver = BCDriverSingleton.getInstance().getDriver();
		PageFactory.initElements(this.driver, this);
	}
	
	/**
	 * This abstract method provides some structure in derived PO classes.
	 */
	public abstract void setKeyPageAttributes();
	
	/**
	 * Navigates to the page.
	 * @throws Exception Throws an Exception if the navigation fails.
	 */
	public void navigateToPage() throws Exception {
		if (this.url != null) {
			WebDriver driver = BCDriverSingleton.getInstance().getDriver();
			driver.navigate().to(this.getURL());
			BCBrowserUtils.isPageReady(driver);
			setActualPageTitle();
			
		} else {
			throw new Exception("navigateToPage() failed: URL not defined.");
		}
	}
	
	/**
	 * Checks if the title based upon the previously
	 * stored expected result. 
	 * @return True or False depending on if the title matches.
	 * @throws Exception Exception if title doesn't exist.
	 */
	public boolean CheckTitle() throws Exception {
		BCBrowserUtils.waitForTitle(this.expPageTitle, 3);
		setActualPageTitle();
		return this.expPageTitle.equals(this.actualPageTitle);
	}
	
	/**
	 * (Overloaded) Checks if the title based upon the previously
	 * stored expected result. 
	 * @param expTitle The title you're expecting to be there.
	 * @return
	 * @throws Exception Exception if title doesn't exist.
	 */
	public boolean CheckTitle(String expTitle) throws Exception {
		this.setExpPageTitle(expTitle);
		BCBrowserUtils.waitForTitle(this.expPageTitle, BCGlobalVariables.ELEMENT_WAIT_MIN);
		this.setActualPageTitle();
		return this.expPageTitle.equals(this.actualPageTitle);
	}
	
	
	/**
	 * Sets the Element Wait
	 * @param elementWait
	 */
	public void setElementWait(int elementWait) {
		this.elementWait = elementWait;
	}
	
	/**
	 * Gets the Element Wait.
	 * @return
	 */
	public int getElementWait() {
		return this.elementWait;
	}
	
	/**
	 * Sets the Expected Page Title.
	 * @param title
	 */
	public void setExpPageTitle(String title) {
		this.expPageTitle = title;
	}
	
	/**
	 * Returns the Expected Page Title.
	 * @return
	 */
	public String getExpPageTitle() {
		return this.expPageTitle;
	}
	
	/**
	 * Sets the Actual Page Title based on the driver.
	 */
	public void setActualPageTitle() {
		this.actualPageTitle = driver.getTitle();
	}
	
	/**
	 * Returns the stored Actual Page Title.
	 * Does not recompute the title. 
	 * @return
	 */
	public String getActualPageTitle() {
		return this.actualPageTitle;
	}

	/**
	 * Sets the URL of the page based on a base URL and the part passed to it.
	 * @param nonBasePath
	 */
	public void setURL(String nonBasePath) {
		this.url = BCGlobalVariables.DEV_ENV_BASE_URL + nonBasePath;
	}
	
	/**
	 * Returns the page URL.
	 * @return the URL
	 */
	public String getURL() {
		return this.url;
	}
}
