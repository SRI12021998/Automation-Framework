package org.ivy.seleniumBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumBase implements WebCoreAPI
{
	long timeOuts = 10;
	long maxWaitTime =15;
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	Actions action;
	JavascriptExecutor je;
	TakesScreenshot ts;
	Robot robot;
	Wait <WebDriver> fluentWait;

	
	@Override
	public void launchBrowser(String url) 
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOuts));
		driver.get(url);
		action = new Actions(driver);
		je = (JavascriptExecutor) driver;
		ts = (TakesScreenshot) driver;
		try 
		{
			robot = new Robot();
		} 
		catch (AWTException e) 
		{
			e.printStackTrace();
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
		fluentWait =new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(15))
		.pollingEvery(Duration.ofMillis(300))
		.ignoring(Exception.class);
	}

	@Override
	public void launchBrowser(String url, Browser browser) 
	{
		switch (browser) 
		{
			case CHROME:
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case EDGE:
				driver = new EdgeDriver();
				break;
			default:
				System.err.println("Driver is not defined");
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOuts));
		driver.get(url);
		action = new Actions(driver);
		je = (JavascriptExecutor) driver;
		ts = (TakesScreenshot) driver;
		try 
		{
			robot = new Robot();
		} 
		catch (AWTException e) 
		{
			e.printStackTrace();
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
		fluentWait =new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(15))
		.pollingEvery(Duration.ofMillis(300))
		.ignoring(Exception.class);
	}

	@Override
	public void close() 
	{
		driver.close();
	}

	@Override
	public void quit() 
	{
		driver.quit();
	}

	@Override
	public WebElement element(Locators type, String value) 
	{
		switch (type) 
		{
	        case id:
	            return driver.findElement(By.id(value));
	        case name:
	            return driver.findElement(By.name(value));
	        case className:
	            return driver.findElement(By.className(value));
	        case tagName:
	            return driver.findElement(By.tagName(value));
	        case cssSelector:
	            return driver.findElement(By.cssSelector(value));
	        case linkText:
	            return driver.findElement(By.linkText(value));
	        case partialLinkText:
	            return driver.findElement(By.partialLinkText(value));
	        case xpath:
	            return driver.findElement(By.xpath(value));
	        default:
	            System.err.println("Locator type is not defined");
	            throw new IllegalArgumentException("Invalid locator type: " + type);
		}

	}

	@Override
	public void switchToWindow(int i) 
	{
		Set<String> windowHandles=driver.getWindowHandles();
		ArrayList<String> windows=new ArrayList<>(windowHandles);
		driver.switchTo().window(windows.get(i));
	}

	@Override
	public void selectValue(WebElement element, String value) 
	{	
		new Select(waitUntilElementVisible(element)).selectByValue(value);
	}

	@Override
	public void selectText(WebElement element, String text) 
	{
		new Select(waitUntilElementVisible(element)).selectByVisibleText(text);
	}

	@Override
	public void selectIndex(WebElement element, int position) 
	{
		new Select(waitUntilElementVisible(element)).selectByIndex(position);
	}

	@Override
	public void click(WebElement element) 
	{
		waitUntilElementClickable(element).click();
	}

	@Override
	public void enterText(WebElement element, String testData) 
	{
		WebElement inputField=waitUntilElementClickable(element);
		inputField.clear();
		inputField.sendKeys(testData);
	}

	@Override
	public void appendText(WebElement element, String testData) 
	{
		waitUntilElementClickable(element).sendKeys(testData);
	}

	@Override
	public String getTitle() 
	{
		return driver.getTitle();
	}

	@Override
	public String getURL() 
	{
		return driver.getCurrentUrl();
	}

	@Override
	public boolean isDisplayed(WebElement element) 
	{
		return element.isDisplayed();
	}

	@Override
	public boolean isEnabled(WebElement element) 
	{
		return element.isEnabled();
	}

	@Override
	public boolean isSelected(WebElement element) 
	{
		return element.isSelected();
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
	public void moveToElement(WebElement element) 
	{
		action.moveToElement(element).perform();
	}

	@Override
	public void moveToElementAndClick(WebElement element) 
	{
		action.moveToElement(element).click().build().perform();
	}

	@Override
	public void clickAndHold(WebElement element) 
	{
		action.clickAndHold(element).perform();
	}

	@Override
	public void release(WebElement element) 
	{
		action.release(element).perform();
	}

	@Override
	public void rightClick(WebElement element) 
	{
		action.contextClick(element).perform();
	}

	@Override
	public void doubleClick(WebElement element) 
	{
		action.doubleClick(element).perform();
	}

	@Override
	public void keyDown(Keys key) 
	{
		action.keyDown(key).perform();
	}

	@Override
	public void keyUp(Keys key) 
	{
		action.keyUp(key).perform();
	}

}
