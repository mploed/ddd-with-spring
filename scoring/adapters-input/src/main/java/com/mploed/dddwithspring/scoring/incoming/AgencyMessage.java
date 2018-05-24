package com.mploed.dddwithspring.scoring.incoming;

public class AgencyMessage {
	private String key;
	private String messageText;

	AgencyMessage(String key, String messageText) {
		this.key = key;
		this.messageText = messageText;
	}

	public String getKey() {
		return key;
	}

	public String getMessageText() {
		return messageText;
	}
}
