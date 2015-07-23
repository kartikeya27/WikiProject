package com.wikia.pages.inbox;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.wikia.base.Page;

public class TopMenu {
	//logout from wikia
	public void Logout() {
		Actions a1 = new Actions(Page.driver);
		a1.moveToElement(Page.driver.findElement(By.xpath(Page.OR.getProperty("top_menu_list")))).build().perform();
		Page.driver.findElement(By.xpath(Page.OR.getProperty("top_menu_logout"))).click();
	}
	
	//got landing page
	public LandingPage gotoLandingpage() {
		Page.driver.findElement(By.xpath(Page.OR.getProperty("homePage_link")));
		return new LandingPage();
	}
}