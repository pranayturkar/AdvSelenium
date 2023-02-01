package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	/**
	 * This method is used to read data from property file
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Ultra
	 */
	
	public String getKeyAndValue(String Key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(Key);
		return value;
	}

}
