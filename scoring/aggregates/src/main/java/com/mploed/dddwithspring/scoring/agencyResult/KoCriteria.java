package com.mploed.dddwithspring.scoring.agencyResult;

class KoCriteria {
	private String key;
	private String messageText;

	KoCriteria(String key, String messageText) {
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
