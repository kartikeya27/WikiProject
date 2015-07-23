package com.wikia.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import com.util.Xls_Reader;
import com.wikia.pages.inbox.TopMenu;

public class Page {
	public static WebDriver driver = null; //static is common for all class
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static TopMenu topMenu = null;
	public static Xls_Reader xls1 = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\xls\\Wikiatest.xlsx");
	public static boolean isLoggedIn=false;
	
	public Page() {
		if(driver==null) {
		//Initialize the properties file
		CONFIG = new Properties();
		OR = new Properties();
		try {
			//CONFIG properties
        	FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\config\\properties\\config.properties");
        	CONFIG.load(fs);
        	//OR properties
        	fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\config\\properties\\OR.properties");
        	OR.load(fs);
        }catch (Exception e) {
        	//error
        	return;
        }
		//System.out.println(CONFIG.getProperty("browser"));
		if(CONFIG.getProperty("browser").equals("Mozilla"))
			this.driver=new FirefoxDriver();
		else if(CONFIG.getProperty("browser").equals("IE"))
			this.driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty("browser").equals("Chrome"))
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
			this.driver=new ChromeDriver();
		}
		//implicit wait for the whole application
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
		
	}
	//move to element
	public void move(String xpathKey) {
		try {
			Actions a1 = new Actions(driver);
			a1.moveToElement(driver.findElement(By.xpath(OR.getProperty(xpathKey)))).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
				//report error
			}
		    
	}
	//click
	public void click(String xpathKey) {
		try {
		driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
		} catch (Exception e) {
			e.printStackTrace();
			//report error
		}
	}
	
	//input
	public void input(String xpathKey, String text) {
		try {
			driver.findElement(By.xpath(OR.getProperty(xpathKey))).sendKeys(text);
			} catch (Exception e) {
				e.printStackTrace();
				//report error
			}
	}
	//verification
	public boolean isElementPresent(String xpathKey) {
		try {
			driver.findElement(By.xpath(OR.getProperty(xpathKey)));
			} catch (Exception e) {
				return false;
				//report error
			}
				return true;
	}
	//finds the link on page
	public boolean isLinkPresent(String linkText) {
		try {
			driver.findElement(By.linkText(linkText));
			} catch (Exception e) {
				return false;
				//report error
			}
				return true;
	}
}
