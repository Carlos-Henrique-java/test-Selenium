package com.thiago.core.util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

/**
* @author thiago.freire
* Define o caminho do driver dos diferentes browsers
* Acessa as configuracoes definidas no config.properties e retorna o valeu do Propertie 
*/
public abstract class Property {

	
	public static String CHROME_DRIVE_IOS_PATH;	
	public static String CHROME_DRIVE_PATH;
	public static String CHROME_DRIVE_LINUX_PATH;
	public static String FIREFOX_DRIVE_LINUX_PATH;
	public static String BROWSER_NAME;
	
	public static String URL;
	
	private static final String PROP_FILE_CONFIG = "config.properties";
	private static final String SRC_SELENIUM = "/src/test/resources/";
	
	static {
		Properties properties 					= getConfig();
		CHROME_DRIVE_PATH 						= new File("").getAbsolutePath() + SRC_SELENIUM + "driver/windows/chromedriver.exe";
		CHROME_DRIVE_IOS_PATH 					= new File("").getAbsolutePath() + SRC_SELENIUM + "chromedriver";
		CHROME_DRIVE_LINUX_PATH 				= new File("").getAbsolutePath() + SRC_SELENIUM + "driver/linux/chromedriver";
		BROWSER_NAME 							= properties.getProperty("browser.name");
		URL										= properties.getProperty("url");
		
	}
	
	public static Properties getConfig(){
		Properties properties = new Properties();
		 InputStream fileIn = ClassLoader.getSystemResourceAsStream(PROP_FILE_CONFIG);
		try {
			properties.load(fileIn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return properties;
	}
}
