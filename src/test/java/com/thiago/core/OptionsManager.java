package com.thiago.core;

import java.io.File;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.thiago.core.util.ConversorTipos;
import com.thiago.core.util.Property;

 
public class OptionsManager {
	
	static String OS = System.getProperty("os.name").toLowerCase();
	static String OS_ARCH = System.getProperty("sun.arch.data.model").toLowerCase();
 
    //Get Chrome Options
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.setHeadless(true);
        try {
			System.setProperty("webdriver.chrome.driver",getFileDriverPathChrome().getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
        return options;
    }
 
    //Get Firefox Options
    public FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setProfile(profile);
        return options;
    }
    public ChromeOptions getRemoteDriverChrome() {
    	try {
			ChromeOptions options = new ChromeOptions();
    		return options;
    	}catch (Exception e) {
			Assert.fail(e.getMessage());
		}
    	return null;
    }
	public FirefoxOptions getRemoteDriverFirefox() {
		try {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			return firefoxOptions;
		}catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @return sistema Operacional Windows
	 */
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}
	/**
	 * @return sistema Operacional Linux
	 */
	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS
				.indexOf("aix") > 0);
	}
	
	public static boolean isOS64bits() {
		if (ConversorTipos.check(OS_ARCH)) {
			return Integer.valueOf(OS_ARCH) == 64;
		}
		return false;
	}
	
	private static File getFileDriverPathChrome() throws Exception{
		File file = null;
			if (isWindows()) {
				file = new File(Property.CHROME_DRIVE_PATH);
			} else if (isUnix()) {
				file = new File(Property.CHROME_DRIVE_LINUX_PATH);
			} else if (isOS64bits()) {
				file = new File(Property.CHROME_DRIVE_IOS_PATH);
			}else
				throw new Exception("Sistema operacional nao compativel");
		return file;
	}	
}