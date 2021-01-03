/**
 * 
 */
package city.beach.qa.utility;

import java.util.Date;

/**
 * Class for creating standard values for variable creation.
 * @author Jacqueline Button
 *
 */
public class BCStandardValues {
	
	/**
	 * Generates a string of the current time stamp.
	 * Useful for creating unique test toots.
	 * @return curDateTimeStr - The current time stamp.
	 */
	public static String genStandardTimestamp() {
		Date curDateTime = new Date();
		String curDateTimeStr = curDateTime.toString();
		
		return curDateTimeStr;
	}
	
}
