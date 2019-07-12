
package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
	
	public static Properties readProperties(String filename) throws Exception
	{
		filename=filename.trim();
		
		InputStream reader=new FileInputStream(filename);
		
		// input stream takes input from any oinput device 
		// abstract class 
		// reader is input stream swhich has data
		Properties properties = new Properties();
		
		properties.load(reader);
		
		
		return properties;
		
	}

}

