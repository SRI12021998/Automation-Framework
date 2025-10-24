package org.ivy.factory;

import org.ivy.seleniumBase.SeleniumBase;

public class BaseFactory
{
	public static SeleniumBase getBase()
	{
		return new SeleniumBase();
	}
}
