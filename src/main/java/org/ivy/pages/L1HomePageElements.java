package org.ivy.pages;

import org.ivy.factory.WaitUtilityFactory;
import org.ivy.seleniumBase.SeleniumBase;
import org.ivy.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class L1HomePageElements
{
	private SeleniumBase base;
	private WaitUtils waitUtils;
	
	public L1HomePageElements(SeleniumBase base)
	{
		PageFactory.initElements(base.getCurrentInstance(), this);
		this.base=base;
		this.waitUtils = WaitUtilityFactory.getWaitUtils();
	}
	
	@FindBy(xpath="//h2[.='Welcome to Cloud DMS - DEV Portal']")
	private WebElement welcomeMessage;
	
	@FindBy(css="iframe[src='/web/DMS/Home']")
	private WebElement homeFrame;
	
	public boolean isWelcomeMessageDisplayed()
	{
		waitUtils.waitAndSwitchToFrame(homeFrame);
		return base.isDisplayed(welcomeMessage);
	}
}