package org.ivy.pages;

import org.openqa.selenium.WebElement;
import org.ivy.seleniumBase.SeleniumBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements
{
	private SeleniumBase base;
	
	public LoginPageElements(SeleniumBase base)
	{
		PageFactory.initElements(base.getCurrentInstance(), this);
		this.base=base;
	}
	
	@FindBy(id="UserName")
	private WebElement userName;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="Login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[.='Recuperar Contraseña']")
	private WebElement recoverPassword;
	
	@FindBy(xpath="//label[.='Usuario *']")
	private WebElement userLabel;
	
	@FindBy(xpath="//label[.='Contraseña *']")
	private WebElement passwordLabel;
	
	public void login()
	{
		base.enterText(userName,"L1_user");
		base.enterText(password,"password1");
		base.click(loginBtn);
	}
	
}
