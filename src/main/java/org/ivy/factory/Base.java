package org.ivy.factory;

import org.ivy.seleniumBase.SeleniumBase;

public class Base
{
	public static SeleniumBase getBaseManager()
	{
		return new SeleniumBase();
	}

}
