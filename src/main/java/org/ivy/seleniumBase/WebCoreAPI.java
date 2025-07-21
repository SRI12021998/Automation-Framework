package org.ivy.seleniumBase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Base interface for common browser actions using Selenium WebDriver.
 * Provides abstract methods for launching browsers, interacting with web elements, handling dropdowns, and switching contexts etc.,
 * 
 * @author Sriram
 */
public interface WebCoreAPI
{

    /**
     * Sets up the WebDriver instance and initializes necessary components.
     * Launches the default chrome browser and navigates to the specified URL.
     * This method should be called before any other actions are performed.
     * 
     * @param url the target URL to open
     * @throws IllegalArgumentException if the URL is null or invalid
     */
    void launchBrowser(String url);

    /**
     * Sets up the WebDriver instance and initializes necessary components.
     * Launches the specified browser and navigates to the given URL.
     * This method should be called before any other actions are performed.
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

    /**
     * Moves the mouse to the middle of the element.
     * @param target element to move to.
     */
    void moveToElement(WebElement element);

    /**
     * Moves the mouse to the middle of the element and click.
     * @param target element to move to.
     */
    void moveToElementAndClick(WebElement element);

    /**
     * Clicks (without releasing) in the middle of the given element
     * @param element Element to click and hold
     */
    void clickAndHold(WebElement element);

    /**
     * Releases the mouse button on the given element
     * @param element Element to release the mouse button on
     */
    void release(WebElement element);

    /**
     * Performs a right-click (context click) on the given element
     * @param element Element to right-click on
     */
    void rightClick(WebElement element);

    /**
     * Performs a double-click on the given element
     * @param element Element to double-click on
     */
    void doubleClick(WebElement element);

    /**
     * Performs a key down action for the specified key
     * @param key the key to press down
     */
    void keyDown(Keys key);

    /**
     * Performs a key up action for the specified key
     * @param key the key to release
     */
    void keyUp(Keys key);

    /**
     * Waits for the page to fully load by checking the document ready state using JavascriptExecutor.
     */
    void jsWaitForPageToLoad();

    /**
     * Scrolls the page to the specified element
     * @param element the WebElement to scroll to
     */
    void jsScrollToElement(WebElement element);

    /**
     * Waits for and clicks an element using JavaScript when native clicks fail
     * @param element The WebElement to click
     */
    void jsClick(WebElement element);

    /**
     * Waits for element visibility, clears existing content, and enters new text
     * @param element the input WebElement
     * @param testData the text to enter
     */
    void jsEnterText(WebElement element, String testData);

    /**
     * Gets the current page title
     * @return the page title as String
     */
    String jsGetPageTitle();

    /**
     * Scrolls the page to the bottom of the page
     */
    void jsScrollToBottom();

    /**
     * Scrolls the page absolute from the top-left corner.
     * Positive values scroll down/right, negative values scroll up/left.
     * @param x horizontal scroll offset
     * @param y vertical scroll offset
     */
    void jsAbsoluteScroll(int x, int y);

    /**
     * Scrolls the page relative to its current position.
     * Positive values scroll down/right, negative values scroll up/left.
     * @param x horizontal scroll offset
     * @param y vertical scroll offset
     */
    void jsRelativeScroll(int x, int y);

    /**
     * Highlights a web element by changing its background color temporarily.
     * This can be useful for debugging or visual confirmation of element presence.
     * @param element the WebElement to highlight
     */
    void jsHighlightElement(WebElement element);

    /**
     * Retrieves the inner text of a web element.
     * @param element the WebElement to retrieve text from
     */
    void jsGetInnerText(WebElement element);

    /**
     * Checks if an element is currently visible.
     * This method can be used to verify visibility even when the element is not interactable.
     * @param element the WebElement to check
     */
    void jsIsElementVisible(WebElement element);

    /**
     * Removes the 'readonly' attribute from an input element.
     * This allows the element to be edited even if it was initially set as read-only.
     * @param element the input WebElement to modify
     */
    void jsRemoveReadonlyAttribute(WebElement element);

    
}
