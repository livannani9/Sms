package com.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.app.models.Account;
import com.app.models.MessageData;
import com.app.models.Messages;
import com.app.models.Responces;
import com.app.models.SmsRequest;
import com.google.gson.Gson;

/**
 * @author Rahulbodapatla
 *
 */
@Controller
public class RestTestController {

	@RequestMapping(value="/sendGroup",method=RequestMethod.POST)
	private String sendRestApi(@RequestParam("mobile") String number, @RequestParam("message") String message,
			Model model) {

		
		System.out.println("Enteing");
		
		System.out.println("Entering to Rest Api ");
		Gson gson=new Gson();
		String url="https://www.smsgatewayhub.com/api/mt/SendSMS";
		StringBuffer status = new StringBuffer();
		status.append("Requested mobile numbers are : ").append(number);

		RestTestController testController=new RestTestController();
		SmsRequest request=new SmsRequest();
		request.setAccount(testController.prepareAccount());
		request.setMessages(testController.prepareMessegeList(number, message));
		
		String json = gson.toJson(request);
		
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity=new HttpEntity(json,headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity,String.class);
		String body = exchange.getBody();
		System.out.println("Body==="+body);
		
		Responces smsResponce = gson.fromJson(body, Responces.class);
		model.addAttribute("Status","Send Success...");
		List<MessageData> messageData = smsResponce.getMessageData();
		if (messageData!=null) {
			for (MessageData messageData2 : messageData) {
				status.append(messageData2.getNumber());
			}
		}
		return "index";
	}
	public static void main(String[] args) {
		String number="9492205320";
		String message="Json Test";
		
		System.out.println("Entering to Rest Api ");
		Gson gson=new Gson();
		String url="https://www.smsgatewayhub.com/api/mt/SendSMS";
	 

		RestTestController testController=new RestTestController();
		SmsRequest request=new SmsRequest();
		request.setAccount(testController.prepareAccount());
		request.setMessages(testController.prepareMessegeList(number, message));
		
		String json = gson.toJson(request);
		
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity=new HttpEntity(json,headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity,String.class);
		String body = exchange.getBody();
		System.out.println("Body==="+body);
		
		Responces smsResponce = gson.fromJson(body, Responces.class);
		
				System.out.println(smsResponce.getErrorMessage());
				System.out.println(smsResponce.getErrorCode());
//				System.out.println(smsResponce.getMessageData().get(0).getMessage());
		
		
		
	}
	private Account prepareAccount(){
		Account account = new Account();
		account.setUser("livan");
		account.setPassword("sms@123");
		account.setChannel("0");
		account.setDcs("0");
		account.setSenderId("TESTIN");
		
		
		return account;
		
	}
	private List<Messages> prepareMessegeList(String number,String text){
		String [] numbers=number.split(",");
		List<Messages> messageList=new ArrayList<Messages>();
		for (String num : numbers) {
				Messages messages=new Messages();
				messages.setNumber(num);
				messages.setText(text);
				messageList.add(messages);
		}
		return messageList;
	}
}
