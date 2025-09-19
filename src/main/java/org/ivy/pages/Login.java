package org.ivy.pages;

import org.openqa.selenium.WebElement;
import org.ivy.seleniumBase.SeleniumBase;
import org.ivy.enums.Locators;
import org.ivy.factory.Base;

public class Login 
{
	SeleniumBase sb=Base.getBaseManager();
	public void LoginPage()
	{
		WebElement username = sb.element(Locators.id, "UserName");
		WebElement password=sb.element(Locators.id, "Password");
		WebElement loginBtn=sb.element(Locators.id, "Password");
	}
	
	
}
