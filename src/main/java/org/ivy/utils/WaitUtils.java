package org.ivy.utils;

import java.time.Duration;

import org.ivy.factory.DriverFactory;
import org.ivy.interfaces.WaitUtilityAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends DriverFactory implements WaitUtilityAPI 
{
	private final static long TIMEOUT = 10;
	private final static long MAX_WAIT = 20;
	private final static long POLLING_INTERVAL = 300;
	private static Wait <RemoteWebDriver> fluentWait;
	private static WebDriverWait wait;
	
	public static void setWaitConfig()
	{
		wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(MAX_WAIT));
		
		fluentWait =new FluentWait<RemoteWebDriver>(DriverFactory.getDriver())
		.withTimeout(Duration.ofSeconds(MAX_WAIT))
		.pollingEvery(Duration.ofMillis(POLLING_INTERVAL))
		.ignoring(Exception.class);
		
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	}
	
	@Override
	public WebElement waitUntilElementVisible(WebElement element) 
	{
		wait.withMessage("Waiting for the element to be visible")
		.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	@Override
	public  WebElement waitUntilElementClickable(WebElement element)
	{
		wait.withMessage("waiting for the element to be clickable")
		.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	@Override
	public void waitAndSwitchToFrame(WebElement element) 
	{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	@Override
	public void waitAndSwitchToFrame(String nameOrId) 
	{
		wait.until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId)));
	}

	@Override
	public void waitAndSwitchToFrame(int index) 
	{
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
	@Override
	public void jsWaitForPageToLoad() 
	{
//		wait.until(base.getCurrentInstance() -> je.executeScript("return document.readyState").equals("complete"));
	}
}
