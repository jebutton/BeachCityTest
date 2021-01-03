package city.beach.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This is the PO class for the Advanced View Timeline.
 * @author Jacqueline Button
 *
 * @param <M>
 */
public class AdvancedViewTimelinePO<M extends  WebElement> extends GenericBrowserPO<M>{
	@FindBy(xpath = "//button[text()='Home']")
	@CacheLookup
	protected M homeColumnHeader;
	
	
	public AdvancedViewTimelinePO() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setKeyPageAttributes() {
		// TODO Auto-generated method stub
		setActualPageTitle();
	}
}
