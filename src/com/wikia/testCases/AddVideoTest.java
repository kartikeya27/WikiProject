package com.wikia.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.wikia.base.Page;
import com.wikia.pages.inbox.LandingPage;
import com.wikia.pages.inbox.VerifyVideoPage;
import com.wikia.pages.inbox.VideoPage;
import com.wikia.pages.login.LoginPage;

	public class AddVideoTest {
		@Test
		public void addVdieoTest() {
		String AddVideourl="http://www.youtube.com/watch?v=h9tRIZyTXT";
		
		LandingPage landingPage=null;
		//logged in inside the Wikia
		
		if(!Page.isLoggedIn) {
			LoginPage loginPage = new LoginPage();
			landingPage = loginPage.doLogin();
		} else {
		//I am logged in
			landingPage = Page.topMenu.gotoLandingpage();
		}
		
		VideoPage vPage =  landingPage.gotoVideoAdd();
		VerifyVideoPage vVideopage = vPage.AddVideoLink();
		vVideopage.searchLink(AddVideourl);
		//Assert.assertEquals(vPage.AddVideo1(AddVideourl),AddVideourl+"Url link is not present");
		Assert.assertEquals("File:The Best Classical Music In The World", Page.driver.findElement(By.linkText("File:The Best Classical Music In The World")).getText());
	}
}
