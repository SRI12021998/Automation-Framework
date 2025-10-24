package org.ivy.interfaces;

import org.openqa.selenium.WebElement;

/**
 * Base interface for explicit waits.
 * Provides abstract methods for waitUntilElementVisible, waitUntilElementClickable  etc.,
 * 
 * @author Sriram
 */
public interface WaitUtilityAPI 
{
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
     * Waits for the page to fully load by checking the document ready state using JavascriptExecutor.
     */
    void jsWaitForPageToLoad();
    
    /**
     * Waits for the element to be available and switch to it
     * @param element Switches to a frame by WebElement.
     */
    void waitAndSwitchToFrame(WebElement element);

    /**
     * Waits for the frame name or id to be available and switch to it
     * @param nameOrId Switches to a frame by nameOrId.
     */
    void waitAndSwitchToFrame(String nameOrId);

    /**
     * Waits for the frame index to be available and switch to it
     * @param nameOrId Switches to a frame by index.
     */
    void waitAndSwitchToFrame(int index);

}
