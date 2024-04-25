package com.appiumtesting.AppiumHandson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
	protected String randomGmail;
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		
	
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//SUMAHALI//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		
		service.start();
		
		return service;
	}
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{
		
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper
				.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		
		});
		
		return data;
		
	}
	
	public void randomEmail() {
		
		String base = "sundarraj";
        String domain = "@gmail.com";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(base);
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(4);
            sb.append(index);
        }
        String randomGmail = sb.toString() + domain;
        System.out.println(randomGmail);
		
	}
	
}
