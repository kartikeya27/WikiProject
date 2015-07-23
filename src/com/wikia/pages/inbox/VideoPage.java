package com.wikia.pages.inbox;

import com.wikia.base.Page;

public class VideoPage extends Page {
	//Add video url
	public void AddVideoUrl(String Videourl) {
		input("video_url",Videourl);
		click("VIDEO_ADD_BUTTON");
	}
	
	public VerifyVideoPage AddVideoLink() {
		return new VerifyVideoPage();
	}
}
