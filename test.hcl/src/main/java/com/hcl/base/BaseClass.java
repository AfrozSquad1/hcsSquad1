package com.hcl.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hcl.utility.TimeUtility;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass(){
	prop=new Properties();
	try {
		FileInputStream fi=new FileInputStream("C:\\Users\\afroz_a\\git\\hcsSquad1\\test.hcl\\config\\config.properties");
		prop.load(fi);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
		}
	}
	
	
	
	public  void initilization() {
		
		String browser=prop.getProperty("browser");
		//System.out.print(browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\afroz_a\\git\\hcsSquad1\\test.hcl\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
						
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\afroz_a\\git\\hcsSquad1\\test.hcl\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
						
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtility.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtility.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
		
}
