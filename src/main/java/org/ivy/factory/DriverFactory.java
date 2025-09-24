package org.ivy.factory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory 
{
	static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	
	protected static RemoteWebDriver initDriver()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		driver.set(new ChromeDriver(option));
		return getDriver();
	}
	
	protected static RemoteWebDriver getDriver()
	{
		return driver.get();
	}
}