package com.mploed.dddwithspring.scoring.agencyResult;

class WarningMessage {
	private String key;
	private String messageText;

	WarningMessage(String key, String messageText) {
		this.key = key;
		this.messageText = messageText;
	}

	String getKey() {
		return key;
	}

	String getMessageText() {
		return messageText;
	}
}
