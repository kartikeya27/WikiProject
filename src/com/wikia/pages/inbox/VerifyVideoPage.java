package com.wikia.pages.inbox;

import com.wikia.base.Page;

public class VerifyVideoPage extends Page {
	public boolean searchLink(String VideoUrl) {
		input("video_url",VideoUrl);
		click("Add_video_url");
		return isLinkPresent(VideoUrl);
	}
}
