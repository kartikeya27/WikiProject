package com.wikia.pages.login;

import org.testng.Assert;
import com.util.ErrorUtil;
import com.wikia.base.Page;
import com.wikia.pages.inbox.LandingPage;

public class LoginPage extends Page {
	//null - if login is not success
	//LandingPage - if login is success
	public LandingPage doLogin(String userName, String password) {
		try {
			Assert.assertEquals("QM HomeWork Wikia", driver.getTitle());
		}catch(Throwable t){
				ErrorUtil.addVerificationFailure(t);
		}
		driver.get(CONFIG.getProperty("testSiteLandingPageURL"));
		move("sign_in_link");
		input("USER",userName);
		input("PASSWORD",password);
		click("LOGIN_BUTTON");
		//validation
		if(isElementPresent("contribute_list"))
			return new LandingPage();
		else
			return null;
	}
	//default - correct , username password
	public LandingPage doLogin() {
		
		return doLogin(CONFIG.getProperty("defaultUserName"),CONFIG.getProperty("defaultPassword"));
	}
}