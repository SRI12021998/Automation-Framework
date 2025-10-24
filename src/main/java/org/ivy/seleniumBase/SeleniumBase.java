package org.ivy.seleniumBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Set;
import org.ivy.enums.Browser;
import org.ivy.enums.Locators;
import org.ivy.factory.DriverFactory;
import org.ivy.factory.WaitUtilityFactory;
import org.ivy.interfaces.WebCoreAPI;
import org.ivy.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumBase extends DriverFactory implements WebCoreAPI
{
	private RemoteWebDriver driver;
	private WaitUtils waitUtils;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor je;
	TakesScreenshot ts;
	Robot robot;
	
	public void setCurrentInstance()
	{
		this.driver=DriverFactory.initDriver();
	}
	
	public RemoteWebDriver getCurrentInstance()
	{
		return this.driver;
	}
	
	
	@Override
	public void launchBrowser(String url) 
	{
		setCurrentInstance();
		WaitUtils.setWaitConfig();
		this.waitUtils = WaitUtilityFactory.getWaitUtils();
		this.driver.get(url);
		
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
		new Select(waitUtils.waitUntilElementVisible(element)).selectByValue(value);
	}

	@Override
	public void selectText(WebElement element, String text) 
	{
		new Select(waitUtils.waitUntilElementVisible(element)).selectByVisibleText(text);
	}

	@Override
	public void selectIndex(WebElement element, int position) 
	{
		new Select(waitUtils.waitUntilElementVisible(element)).selectByIndex(position);
	}

	@Override
	public void click(WebElement element) 
	{
		waitUtils.waitUntilElementClickable(element).click();
	}

	@Override
	public void enterText(WebElement element, String testData) 
	{
		WebElement inputField=waitUtils.waitUntilElementClickable(element);
		inputField.clear();
		inputField.sendKeys(testData);
	}

	@Override
	public void appendText(WebElement element, String testData) 
	{
		waitUtils.waitUntilElementClickable(element).sendKeys(testData);
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

	@Override
	public void jsScrollToElement(WebElement element) 
	{
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@Override
	public void jsClick(WebElement element) 
	{
		je.executeScript("arguments[0].click();", element);
	}

	@Override
	public void jsEnterText(WebElement element, String testData) 
	{
		je.executeScript("arguments[0].value=arguments[1];", element, testData);
	}

	@Override
	public String jsGetPageTitle() 
	{
		return String.valueOf(je.executeScript("return document.title;"));
	}

	@Override
	public void jsScrollToBottom() 
	{
		je.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	@Override
	public void jsAbsoluteScroll(int x, int y) 
	{
		je.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
	}

	@Override
	public void jsRelativeScroll(int x, int y) 
	{
		je.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	@Override
	public void jsHighlightElement(WebElement element) 
	{
		je.executeScript("arguments[0].style.border='3px solid red';", element);
	}

	@Override
	public String jsGetInnerText(WebElement element) 
	{
		return (String)je.executeScript("return arguments[0].innerText;", element);
	}

	@Override
	public boolean jsIsElementVisible(WebElement element) 
	{
		return (Boolean)je.executeScript("return arguments[0].offsetWidth>0&&arguments[0].offsetHeight>0;", element);
	}

	@Override
	public void jsRemoveReadonlyAttribute(WebElement element) 
	{
		je.executeScript("arguments[0].removeAttribute('readonly');", element);
	}
	
}
