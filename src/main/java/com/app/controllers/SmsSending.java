package com.app.controllers;

import javax.swing.text.html.FormSubmitEvent.MethodType;

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

import com.app.models.Responces;
import com.google.gson.Gson;

@Controller
public class SmsSending {

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	private String sending(@RequestParam("mobile") String number, @RequestParam("message") String message,
			Responces responces, Model model) {

		System.out.println("entering into seding sms");

		StringBuffer url = new StringBuffer();

		url.append("https://www.smsgatewayhub.com/api/mt/SendSMS?");
		url.append("APIKey=");
		url.append("wJCC8jKR4E6Jz9v8rCMQyw&");
		url.append("senderid=TESTIN&");
		url.append("channel=2&");
		url.append("DCS=0&");
		url.append("flashsms=0&");
		url.append("number=" + number + "&");
		url.append("text=" + message + "&");
		url.append("route=1");

		Gson gson = new Gson();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<String> exchange = restTemplate.exchange(url.toString(), HttpMethod.POST, entity, String.class);
		String body = exchange.getBody();
		System.out.println("Respone :" + body);

		Responces fromJson = gson.fromJson(body, Responces.class);
		int errorCode = fromJson.getErrorCode();
		String errorMessage = fromJson.getErrorMessage();
		System.out.println("error Message=" + errorMessage);
		System.out.println("error code=" + errorCode);

		model.addAttribute("Status", "Congratulations Sending Message SuccessFully....");
		return "index";
	}
	public static void main(String[] args) {
	
		StringBuffer url = new StringBuffer();
		
		String number="8555923587";
		url.append("https://www.smsgatewayhub.com/api/mt/SendSMS?");
		url.append("APIKey=");
		url.append("wJCC8jKR4E6Jz9v8rCMQyw&");
		url.append("senderid=TESTIN&");
		url.append("channel=2&");
		url.append("DCS=0&");
		url.append("flashsms=0&");
		url.append("number=" +  number+ "&");
		url.append("text=" + "&");
		url.append("route=1");

		Gson gson = new Gson();

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<String> exchange = restTemplate.exchange(url.toString(), HttpMethod.POST, entity, String.class);
		String body = exchange.getBody();
		System.out.println("Respone :" + body);

		Responces fromJson = gson.fromJson(body, Responces.class);
		int errorCode = fromJson.getErrorCode();
		String errorMessage = fromJson.getErrorMessage();
		System.out.println("error Message=" + errorMessage);
		System.out.println("error code=" + errorCode);

		
	}
}
