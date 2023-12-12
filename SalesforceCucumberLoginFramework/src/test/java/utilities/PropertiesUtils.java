package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtils {

	private FileInputStream stream = null;
	
	public PropertiesUtils createPropertyObject() {
		return new PropertiesUtils();
	}

	public PropertiesUtils loadFile(String filename,PropertiesUtils properties) {
		//propFile=new Properties();
		String propertyFilePath=null;
		switch(filename) {
		case "applicationDataProperties":
			System.out.println( " i reached property file");
			propertyFilePath=Constants.APPLICATION_PROPERTIES;
			System.out.println("taken the file " +propertyFilePath);
			break;
		case "HomePAge":
			propertyFilePath=Constants.HOME_PAGE_PROPERTIES;
			break;
			
		}
		try {
			stream=new FileInputStream(propertyFilePath);
			properties.load(stream);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
		
	}

	public String getPropertyValue(String key, PropertiesUtils properties) {
		System.out.println(key +"key property values");
		String value = properties.getProperty(key);
		return value;

	}

	public void setPropertyValue(String key, String value, PropertiesUtils properties) {
		properties.setProperty(key, value);

	}

	public void savePropertyFile(String filepath, PropertiesUtils properties) {
		try {
			FileOutputStream output = new FileOutputStream(filepath);
			properties.store(output, filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeDataToPropertyFile(File path, String key, String value) {

		PropertiesUtils propFile = new PropertiesUtils();
		propFile.setProperty(key, value);
		try {
			propFile.store(new FileOutputStream(path), "updating data");

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}