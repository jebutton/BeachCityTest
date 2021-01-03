package city.beach.qa.utility;
/**
 * Class containing Global variables for the beach.city automation.
 * @author Jacqueline Button
 *
 */
public class BCGlobalVariables {
	
	public static final String BROWSER = null;
	public static final String PLATFORM = null;
	public static final String ENVIRONMENT = "remote";
	
	public static final String DEV_ENV_BASE_URL = "local";
	public static String DEV_ENV_BROWSER = null;
    public static String DEV_PLATFORM = null;
    public static String DEV_ENVIRONMENT = null;
    public static String DEV_PROPS_PATH = null;
    
    public static final String TEST_ENV_BASE_URL = "local";
	public static String TEST_ENV_BROWSER = null;
    public static String TEST_ENV_PLATFORM = null;
    public static String TEST_ENVIRONMENT = null;
    public static String TEST_ENV_PROPS_PATH = null;
    
    public static final String PROD_URL = "https://beach.city/";
	
	public static final String TEST_OUTPUT_PATH = "testOutput/";
	public static final String LOGFILE_PATH = TEST_OUTPUT_PATH + "Logs/";
	public static final String REPORT_PATH = TEST_OUTPUT_PATH + "Reports/";
	public static final String BITMAP_PATH = TEST_OUTPUT_PATH + "Bitmaps/";
	
	// Timeout constants
	public static final int TIMEOUT_MINUTE = 60;
	public static final int TIMEOUT_SECOND = 1;
	public static final int TIMEOUT_ZERO = 0;
	public static final int TIMEOUT_ELEMENT = TIMEOUT_MINUTE * 5;
	
	// Wait Constants
	public static final int ELEMENT_WAIT_MIN = 3;
	public static final int ELEMENT_WAIT_MAX = 10;
	
}
