package com.wikia.pages.inbox;

import com.wikia.base.Page;

public class LandingPage extends Page {
	
	public VideoPage gotoVideoAdd() {
		click("contribute_list");
		click("add_video");
		return new VideoPage();
	}
}
