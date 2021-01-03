package city.beach.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
/**
 * The Page Object class for the About page (not the Login Page).
 * @author buttonje
 *
 * @param <M>
 */
public class AboutPagePO<M extends  WebElement> extends GenericBrowserPO<M>{
	@FindBy(id = "login_user_email")
	@CacheLookup
	protected M loginEmailInputField;
	
	@FindBy(id = "login_user_password")
	@CacheLookup
	protected M loginPWInputField;
	
	@FindBy(xpath = "//button[text()='Log in']")
	@CacheLookup
	protected M loginButton;
	
	@FindBy(xpath = "//a[text()='Trouble logging in?']")
	@CacheLookup
	protected M troubleLoggingInLink;
	
	public AboutPagePO() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setKeyPageAttributes() {
		setExpPageTitle("beach.city - Beach City");
		setActualPageTitle();
	}

	/**
	 * Logs into the app via Username and password.
	 * @param username
	 * @param pw
	 */
	public void signIn(String username, String pw) {
		loginEmailInputField.sendKeys(username);
		loginPWInputField.sendKeys(pw);
		loginButton.click();
	}
	
	/**
	 * Returns the element of the Login Email Input Field.
	 * @return M loginEmailInputField;
	 * @throws Exception
	 */
	public M getLoginEmailInputField() throws Exception {
		return loginEmailInputField;
	}
	
	/**
	 * Returns the element of the loginPWInputField.
	 * @return M loginPWInputField
	 * @throws Exception
	 */
	public M getLoginPWInputField() throws Exception {
		return loginPWInputField;
	}
	
	/**
	 * Returns the element of the Login Button.
	 * @return M loginButton
	 * @throws Exception
	 */
	public M getLoginButton() throws Exception {
		return loginButton;
	}
	
	/**
	 * Returns the element of the Trouble Logging In Link
	 * @return troubleLogginInLink
	 * @throws Exception
	 */
	public M gettroubleLoggingInLink() throws Exception {
		return troubleLoggingInLink;
	}
}
