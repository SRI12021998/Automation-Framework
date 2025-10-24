package org.ivy.factory;

import org.ivy.utils.WaitUtils;

public class WaitUtilityFactory
{
	public static WaitUtils getWaitUtils()
	{
		return new WaitUtils();
	}
}
