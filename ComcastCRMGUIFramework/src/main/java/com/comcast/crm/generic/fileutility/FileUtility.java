package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream file=new FileInputStream("./src/test/resources/data1.properties");
		Properties prop=new Properties();
		prop.load(file);
		String data = prop.getProperty(key);
		return data;
	}
}
