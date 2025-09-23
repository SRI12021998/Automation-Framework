package testcases;

import org.ivy.common.BaseTest;
import org.ivy.pages.L1HomePageElements;
import org.ivy.pages.LoginPageElements;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends BaseTest
{	
	@Test(description="Verify able to login")
	public void LoginTest()
	{
		LoginPageElements loginPage=new LoginPageElements(super.base);
		loginPage.login();
		L1HomePageElements homePage=new L1HomePageElements(super.base);
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}
}
