/**
 * 
 */
package city.beach.qa.tests;

import static org.testng.Assert.assertEquals;

import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import city.beach.qa.driver.BCDriverSingleton;
import city.beach.qa.pages.LoginPagePO;
import city.beach.qa.utility.BCGlobalVariables;

/**
 * Class for basic tests to determine if build built or not.
 * @author Jacqueline Button
 *
 */
public class SmokeTest {
	private LoginPagePO<WebElement> loginPage = null;
	
	public SmokeTest() throws Exception {
	}
	
	@BeforeSuite(enabled=true, alwaysRun=true)
	protected void smokeTestSuiteSetup(@Optional(BCGlobalVariables.ENVIRONMENT)
										ITestContext context) throws Exception {
		
		
		
		BCDriverSingleton.getInstance().setDriver("chrome", null, null, null);
		this.loginPage = new LoginPagePO<WebElement>();
	}
	
	@AfterClass(alwaysRun =  true)
	protected void closeDriver() {
		BCDriverSingleton.getInstance().closeDriver();
	}
	
	@Test(enabled = true) 
	public void tc001_verifyLoginPageLoads() throws Exception {
		String tcName = "tc001_verifyLoginPageLoads";

		try {
			//this.loginPage.navigateToPage();
			System.out.println(this.loginPage.getURL());
			BCDriverSingleton.getInstance().getDriver().get(this.loginPage.getURL());			
			System.out.println(this.loginPage.getActualPageTitle());
			
		} catch (Exception e) {
			throw new Exception(tcName + " fails due to failure " +
							"to navigate to page. MSG: " + e.getMessage());
		}
		WebElement emailField = this.loginPage.getEmailInputField();
		assertEquals(emailField.isEnabled(), true, tcName + " fails due to Email Field not enabled");
		
	}
}
