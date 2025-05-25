package com.qa.ual.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ual.base.BaseTest;
import com.qa.ual.constants.AppConstants;

import java.util.
public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void loginPageNavigationTest() {
		loginPage = homePage.navigateToLoginPage();
		
		String title = loginPage.getLoginPageTitle();
		
		Assert.assertEquals(title, AppConstants.ACCOUNT_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void forgotPWDTest() {
		boolean pwdlink = loginPage.isForgotPWDLinkExists();
		
		Assert.assertEquals(pwdlink, true);
	}
	
	@Test(priority=3)
	public void doLoginTest() throws InterruptedException {
		boolean bStatus =loginPage.doLogin(prop.getProperty("user"), prop.getProperty("password"));
		Assert.assertEquals(bStatus, true);
	}
}
