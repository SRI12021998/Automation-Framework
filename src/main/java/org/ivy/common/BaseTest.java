package org.ivy.common;

import org.ivy.factory.BaseFactory;
import org.ivy.seleniumBase.SeleniumBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest
{
	protected SeleniumBase base;
	
	@BeforeSuite()
	public void initSetup()
	{
		this.base=BaseFactory.getBase();
		base.launchBrowser("https://bimbo-co-uat.ivycpg.com/web/DMS");
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void tearDown()
	{
		base.quit();
	}
}
