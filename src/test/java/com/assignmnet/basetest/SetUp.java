package com.assignmnet.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {
	
	static ThreadLocal<WebDriver> driver=new ThreadLocal();
	
	public static void browserInitalization(String browser)
	
	{
		if(browser.equalsIgnoreCase(BrowserType.CHROME))
		{
			ChromeOptions chromOptios=new ChromeOptions();
			
			
				chromOptios.setAcceptInsecureCerts(true);
				chromOptios.addArguments("--incognito");
				chromOptios.addArguments("window-size=1480,860");	
				driver.set(WebDriverManager.chromedriver().capabilities(chromOptios).driverVersion("125").clearResolutionCache().create());
				
			
			
		}
		
	}
	
	public static  WebDriver getDriver() {
		
		
		return driver.get();
		
	}
	
	public static void quitDriver()
	{
		getDriver().quit();
	}
	
			
	

}
