package city.beach.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import city.beach.qa.utility.BCGlobalVariables;
import city.beach.qa.utility.BCSyncTools;

/**
 * Class to represent the login page (not the About page).
 * @author Jacqueline Button.
 *
 * @param <M> Extends the WebElement class.
 */
public class LoginPagePO<M extends  WebElement> extends GenericBrowserPO<M>{
	// Page Objects
	
	// The input field for the email for log in.
	@FindBy(id = "user_email")
	@CacheLookup
	protected M emailInputField;
	
	// The input field for the password for log in.
	@FindBy(id = "user_password")
	@CacheLookup
	protected M pwInputField;
	
	// The button used to log in.
	@FindBy(xpath = "//button[text()='Log in']")
	@CacheLookup
	protected M loginButton;
	
	// The link used to sign up.
	@FindBy(xpath = "//a[text()='Sign up']")
	@CacheLookup
	protected M signUpLink;
	
	// The link for if you forgot your password.
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	@CacheLookup
	protected M forgotPWLink;
	
	// The link for if your confirmation instructions failed to be sent.
	@FindBy(xpath = "//a[text()='Didn't receive confirmation instructions?']")
	@CacheLookup
	protected M failedConfirmationInstructionsLink;
	
	
	public LoginPagePO() throws Exception {
		super();
		setKeyPageAttributes();
	}
	

	@Override
	public void setKeyPageAttributes() {
		setExpPageTitle("Log in - Beach City");
		setURL("auth/sign_in");
		System.out.println(this.getURL());
	}
	
	/**
	 * Signs into the application.
	 * @param username The email address of the user.
	 * @param password The password of the user.
	 * @exception The Exception thrown if something is wrong.
	 */
	public void signIn(String username, String password) throws Exception{
		BCSyncTools.waitForElement(this.emailInputField, BCGlobalVariables.ELEMENT_WAIT_MIN);
		BCSyncTools.waitForElement(pwInputField, BCGlobalVariables.ELEMENT_WAIT_MIN);
		BCSyncTools.waitForElement(loginButton, BCGlobalVariables.ELEMENT_WAIT_MIN);
		this.emailInputField.sendKeys(username);
		this.pwInputField.sendKeys(password);
		this.loginButton.click();
	}

	/**
	 * Returns the email input field.
	 * @return the emailInputField
	 */
	public M getEmailInputField() {
		return emailInputField;
	}

	/**
	 * Returns the Password Input field.
	 * @return the pwInputField
	 */
	public M getPwInputField() {
		return pwInputField;
	}
	
	/**
	 * Returns the Login Button.
	 * @return the loginButton
	 */
	public M getLoginButton() {
		return loginButton;
	}

	/**
	 * Returns the link to sign up.
	 * @return the signUpLink
	 */
	public M getSignUpLink() {
		return signUpLink;
	}

	/**
	 * Returns the link if you forgot your password.
	 * @return the forgotPWLink
	 */
	public M getForgotPWLink() {
		return forgotPWLink;
	}

	/**
	 * Returns the link if your Confirmation Instructions failed to be sent.
	 * @return the failedConfirmationInstructionsLink
	 */
	public M getFailedConfirmationInstructionsLink() {
		return failedConfirmationInstructionsLink;
	}
}
