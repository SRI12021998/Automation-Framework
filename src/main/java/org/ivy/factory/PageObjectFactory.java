package org.ivy.factory;

import org.ivy.seleniumBase.SeleniumBase;

public class PageObjectFactory 
{
	public <T> T getPageInstance(Class<T> pageClass,SeleniumBase base)
	{
		try 
		{
			return pageClass.getDeclaredConstructor(SeleniumBase.class).newInstance(base);
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("failed to create page instance: "+pageClass.getSimpleName(),e);
		} 
	}

}