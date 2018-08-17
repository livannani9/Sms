package com.app.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SmsRequest {
	
	@SerializedName("Account")
	private Account account;
	@SerializedName("Messages")
	private List<Messages> messages;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Messages> getMessages() {
		return messages;
	}
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	
	
	
	

	

}
