package testcases;

import org.ivy.common.BaseTest;
import org.ivy.factory.PageObjectFactory;
import org.ivy.pages.L1HomePageElements;
import org.ivy.pages.LoginPageElements;
import org.ivy.utils.TestListenerUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListenerUtil.class)
public class Login extends BaseTest
{	
	private PageObjectFactory pages;
	
	@BeforeMethod()
	public void initPages()
	{
		pages=new PageObjectFactory();
	}
	
	@Test(description="Verify able to login with valid credentials")
	public void LoginTest()
	{
		LoginPageElements loginPage=pages.getPageInstance(LoginPageElements.class, super.base);
		loginPage.login();
		L1HomePageElements homePage=pages.getPageInstance(L1HomePageElements.class, super.base);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}
}