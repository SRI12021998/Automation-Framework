package org.ivy.factory;

import org.ivy.seleniumBase.SeleniumBase;

public class BaseManager
{
	public static SeleniumBase getBase()
	{
		return new SeleniumBase();
	}
	
}
