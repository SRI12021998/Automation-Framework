package org.ivy.seleniumBase;

import org.openqa.selenium.WebElement;

/**
 * Base interface for common browser actions using Selenium WebDriver.
 * Provides abstract methods for launching browsers, interacting with web elements, handling dropdowns, and switching contexts etc.,
 * 
 * @author Sriram
 */
public interface WebAutomationCore 
{

    /**
     * Launches the browser and navigates to the specified URL.
     *
     * @param url the target URL to open
     * @throws IllegalArgumentException if the URL is null or invalid
     */
    void launchBrowser(String url);

    /**
     * Launches the specified browser and navigates to the given URL.
     *
     * @param url the target URL to open
     * @param browser the browser type to launch
     * @throws IllegalArgumentException if the URL is null or invalid
     */
    void launchBrowser(String url, Browser browser);

    /**
     * Closes the active browser window.
     */
    void close();

    /**
     * Quits the WebDriver instance and closes all associated windows.
     */
    void quit();

    /**
     * Finds and returns a web element based on the provided locator type and value.
     *
     * @param type the locator strategy (e.g., ID, NAME, LINKTEXT)
     * @param value the value of the locator
     * @return the matching WebElement
     */
    WebElement element(Locators type, String value);

    /**
     * Switches to a specific browser tab/window by index
     * @param i the index of the window to switch to
     */
    void switchToWindow(int i);

    /**
     * Selects a dropdown option by value attribute
     * @param element the dropdown WebElement
     * @param value the value attribute to select
     */
    void selectValue(WebElement element, String value);

    /**
     * Selects a dropdown option by visible text
     * @param element the dropdown WebElement
     * @param text the visible text to select
     */
    void selectText(WebElement element, String text);

    /**
     * Selects a dropdown option by index position
     * @param element the dropdown WebElement
     * @param position the index position to select
     */
    void selectIndex(WebElement element, int position);

    /**
     * Waits for and clicks an element when it becomes clickable
     * @param element the WebElement to click
     */
    void click(WebElement element);

    /**
     * Waits for element visibility, clears existing content, and enters new text
     * @param element the input WebElement
     * @param testData the text to enter
     */
    void enterText(WebElement element, String testData);

    /**
     * Waits for element visibility and appends text to existing content
     * @param element the input WebElement
     * @param testData the text to append
     */
    void appendText(WebElement element, String testData);

    /**
     * Gets the title of the current active page
     * @return the page title as String
     */
    String getTitle();

    /**
     * Gets the URL of the current active page
     * @return the page URL as String
     */
    String getURL();

    /**
     * Checks whether an element is currently visible
     * @param element the WebElement to check
     * @return true if the element is visible, false otherwise
     */
    boolean isDisplayed(WebElement element);
    
    /**
     * Checks whether an element is currently visible
     * @param element the WebElement to check
     * @return true if the element is visible, false otherwise
     */
    boolean isEnabled(WebElement element);
    
    /**
     * Checks whether an element is currently visible
     * @param element the WebElement to check
     * @return true if the element is visible, false otherwise
     */
    boolean isSelected(WebElement element);
    
    /**
     * Waits until the element is visible and returns it.
     * @param element the WebElement to wait for
     * @return the visible WebElement
     */
    WebElement waitUntilElementVisible(WebElement element);
    
    /**
     * Waits until the element is clickable and returns it.
     * @param element the WebElement to wait for
     * @return the clickable WebElement
     */
    WebElement waitUntilElementClickable(WebElement element);
}
